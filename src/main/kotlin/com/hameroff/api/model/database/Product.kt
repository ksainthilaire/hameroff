package com.hameroff.api.model.database

import javax.persistence.*

@Entity
@Table(name = "hameroff_products")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var price: Double? = null,
    var deliveryTime: Long = 168
)