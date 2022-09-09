package com.hameroff.api.repositories

import com.hameroff.api.model.UserVerification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.sql.Timestamp
import java.util.*

interface IUserVerificationRepository : JpaRepository<UserVerification, Long> {
    fun findByToken(token: String) : Optional<UserVerification>

    @Modifying
    @Query("Update UserVerification verification SET verification.token=:token, verification.expiresAt=:expires_at WHERE verification.id=:id")
    fun updateToken(
        @Param("id") id: Long?, @Param("token") token: String?,
        @Param("expires_at") expiresAt: Timestamp?
    )
}