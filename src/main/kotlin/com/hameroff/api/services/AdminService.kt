package com.hameroff.api.services

import com.hameroff.api.repositories.IUserDeletionRepository
import com.hameroff.api.repositories.IUserForgotRepository
import com.hameroff.api.repositories.IUserRepository
import com.hameroff.api.repositories.IUserVerificationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AdminService @Autowired constructor(
    var userRepository: IUserRepository,
    val userForgot: IUserForgotRepository,
    var userVerification: IUserVerificationRepository,
    var userDeletion: IUserDeletionRepository
) {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder;

}
