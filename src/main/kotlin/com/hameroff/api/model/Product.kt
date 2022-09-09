package com.hameroff.api.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "hameroff_products")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var price: String? = null,
    var deliveryTime: Long = 168
)