package com.hameroff.api.services

import com.hameroff.api.forms.RegisterForm
import com.hameroff.api.model.User
import com.hameroff.api.model.UserDeletion
import com.hameroff.api.model.UserVerification
import com.hameroff.api.repositories.IUserDeletionRepository
import com.hameroff.api.repositories.IUserForgotRepository
import com.hameroff.api.repositories.IUserRepository
import com.hameroff.api.repositories.IUserVerificationRepository
import com.hameroff.api.utils.createTimestamp
import com.hameroff.api.utils.getCurrentTimestamp
import com.hameroff.api.utils.isAvailable
import com.hameroff.api.utils.isExpired
import net.bytebuddy.utility.RandomString
import org.apache.commons.validator.routines.EmailValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.sql.Timestamp
import java.util.*

@Service
@Transactional
class UserService @Autowired constructor(
    var userRepository: IUserRepository,
    val userForgot: IUserForgotRepository,
    var userVerification: IUserVerificationRepository,
    var userDeletion: IUserDeletionRepository
) {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder;

    fun getAllUsers(): MutableIterable<User> = userRepository.findAll()

    fun getUserById(id: Long): User =
        userRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)


    fun login() {

    }

    fun createUser(form: RegisterForm): User {

        if (userEmailExists(form.mail)) {
            throw ResponseStatusException(HttpStatus.CONFLICT)
        }

        if (!EmailValidator.getInstance().isValid(form.mail)) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        }

        val user = User(
            firstName = form.firstName,
            lastName = form.lastName,
            mail = form.mail,
            password = passwordEncoder.encode(form.password)
        )


        return userRepository.save(user)
    }

    private fun sendVerificationEmail(user: User) {
        val result = userVerification.findById(user.id!!)
        if (result.isPresent) {
            val verification = result.get()

            val currentDate = Date()
            currentDate.time = System.currentTimeMillis()
            if (currentDate.before(verification.expiresAt)) {
                throw Throwable(""); //The verification email has already sent; Wait 5 minutes before sending
            }

            userVerification.deleteById(verification.id!!)
        }
        val verification = UserVerification(userId = user.id)

        val token = RandomString.make(TOKEN_LENGTH)
        verification.token = token

        verification.expiresAt = createTimestamp(TOKEN_LIFETIME)

        userVerification.save(verification)
    }

    fun validateEmail(token: String) {
        val result = userVerification.findByToken(token)
        if (result.isEmpty) {
            throw Throwable("") // No email was sent with this token
        }

        val verification = result.get()
        val expiresAt = verification.expiresAt!!


        if (expiresAt.isExpired()) throw Throwable(""); //The token has expired


        userVerification.deleteById(verification.id!!)

        val user = userRepository.findById(verification.userId!!).get()
        user.verifiedAt = Calendar.getInstance().time as Timestamp

        userRepository.save(user)
    }


    fun requestDeletion(userId: Long) {
        val deletionRequest = UserDeletion(
            userId = userId,
            token = RandomString.make(TOKEN_LENGTH),
            expiresAt = createTimestamp(
                TOKEN_LENGTH
            )
        )
        userDeletion.save(deletionRequest)
        // Send email for user deletion
    }


    fun validateDeletion(token: String) {
        val deletionRequest = userDeletion.findByToken(token)
        if (deletionRequest.isPresent) {
            deletionRequest.get().let {
                val user = getUserById(it.userId!!)
                val isValidToken = it.expiresAt!!.isAvailable()
                if (isValidToken) {
                    user.deletedAt = getCurrentTimestamp()
                    userRepository.save(user)
                    // Send email confirming user deletion
                    return ;
                }
                userDeletion.delete(it)
                // The token has expired
            }
        }
        // The token does not exist
        // A script should be run periodically to delete users who have been deleted for 30 days.
    }

    fun reactivateAccount(userId: Long) {
        val user = getUserById(userId)
        user.deletedAt = null
        userRepository.save(user)
        // Send an email confirming account reactivation
    }

    fun forgot(userId: Long) {
        val result = userForgot.findById(userId)
        if (result.isPresent) {
            val forgot = result.get()
            val isValidToken = forgot.expiresAt!!.isAvailable()
            if (isValidToken) {
                throw Throwable() // The token is not expired
            }
        }
    }

    fun resetPassword() {

    }


    fun userEmailExists(email: String): Boolean = userRepository.findByMail(email).isPresent


    fun updateUser(id: Long, user: User) {
        if (userRepository.existsById(id)) {
            user.id = id
            userRepository.save(user)
        }
    }

    companion object {
        const val TOKEN_LENGTH: Int = 30
        const val TOKEN_LIFETIME: Int = 5
    }

}