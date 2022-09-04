package com.hameroff.api.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "hameroff_user_forgot")
data class UserForgot(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var userId: Long? = null,
    var token: String? = null,
    var expiresAt: Timestamp? = null
)