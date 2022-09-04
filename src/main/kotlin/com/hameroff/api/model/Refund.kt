package com.hameroff.api.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "hameroff_refunds")
data class Refund(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var orderId: Long? = null,
    var reason: String? = null
)

