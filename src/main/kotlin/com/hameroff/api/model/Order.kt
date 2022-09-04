package com.hameroff.api.model

import javax.persistence.*

@Entity
@Table(name = "hameroff_orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var userId: Long? = null,
    var transactionId: Long? = null,
    var productId: Long? = null,
    var quantity: Long? = null,
    var status: Long? = null
)