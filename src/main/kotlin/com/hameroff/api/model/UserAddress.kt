package com.hameroff.api.model

import javax.persistence.*

@Entity
@Table(name = "hameroff_user_addresses")
data class UserAddress(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var name: String? = null,
    var phone: String? = null,
    var details: String? = null,
    var otherDetails: String? = null,
)