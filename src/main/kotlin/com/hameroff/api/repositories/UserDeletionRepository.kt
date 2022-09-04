package com.hameroff.api.repositories

import com.hameroff.api.model.UserDeletion
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserDeletionRepository : JpaRepository<UserDeletion, Long> {
    fun findByToken(token: String) : Optional<UserDeletion>
}