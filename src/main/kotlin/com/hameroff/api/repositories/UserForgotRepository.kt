package com.hameroff.api.repositories

import com.hameroff.api.model.UserForgot
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserForgotRepository : JpaRepository<UserForgot, Long> {
    fun findByToken(token: String) : Optional<UserForgot>
}