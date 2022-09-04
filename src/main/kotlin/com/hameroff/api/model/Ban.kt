package com.hameroff.api.model

import javax.persistence.*

@Entity
@Table(name = "hameroff_bans")
data class Ban(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var orderId: Int? = null,
    var reason: String? = null,
)