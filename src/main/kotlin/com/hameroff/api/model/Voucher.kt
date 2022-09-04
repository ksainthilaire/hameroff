package com.hameroff.api.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "hameroff_user_voucher")
data class Voucher(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var voucherCode: String? = null,
    var productId: Int? = null,
    var expiresAt: Timestamp? = null
)