package com.hameroff.api.repositories

import com.hameroff.api.model.UserForgot
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ForgotRepository : JpaRepository<UserForgot, Long>