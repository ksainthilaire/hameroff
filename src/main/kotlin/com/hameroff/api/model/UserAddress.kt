package com.hameroff.api.model

import javax.persistence.*

@Entity
@Table(name = "hameroff_user_addresses")
data class UserAddress(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,

    @Column(name= "user_id")
    var userId: Long? = null,
    var name: String? = null,
    var phone: String? = null,
    var details: String? = null,

    @Column(name = "other_details")
    var otherDetails: String? = null,
)