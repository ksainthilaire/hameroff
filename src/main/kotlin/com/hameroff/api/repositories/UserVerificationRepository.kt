package com.hameroff.api.repositories

import com.hameroff.api.model.UserVerification
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserVerificationRepository : JpaRepository<UserVerification, Long> {
    fun findByToken(token: String) : Optional<UserVerification>
}