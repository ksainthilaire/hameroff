package com.hameroff.api.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "hameroff_user_forgot")
data class Transaction(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    @Column(name = "user_id")
    var userId: Long? = null,

    @Column(name = "product_id")
    var productId: Int? = null
)