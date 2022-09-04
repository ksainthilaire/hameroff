package com.hameroff.api.services

import com.hameroff.api.repositories.UserDeletionRepository
import com.hameroff.api.repositories.UserForgotRepository
import com.hameroff.api.repositories.UserRepository
import com.hameroff.api.repositories.UserVerificationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AdminService @Autowired constructor(
    var userRepository: UserRepository,
    val userForgot: UserForgotRepository,
    var userVerification: UserVerificationRepository,
    var userDeletion: UserDeletionRepository
) {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder;

}
