package com.hameroff.api.model

import javax.persistence.*

@Entity
@Table(name = "hameroff_shop")
data class Shop(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var name: String? = null,
    var isMultipleProducts: Boolean = false
)
