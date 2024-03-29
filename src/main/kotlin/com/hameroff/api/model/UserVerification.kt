package com.hameroff.api.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "hameroff_user_verification")
data class UserVerification(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    @Column(name="user_id")
    var userId: Long? = null,

    var token: String? = null,

    @Column(name="expires_at")
    var expiresAt: Timestamp? = null
)