package com.hameroff.api.model.database

import javax.persistence.*

@Entity
@Table(name = "hameroff_refunds")
data class Refund(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,

    @Column(name = "order_id")
    var orderId: Long? = null,
    var reason: String? = null
)

