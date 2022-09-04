package com.hameroff.api.repositories

import com.hameroff.api.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun findByMail(mail: String) : Optional<User>

}
