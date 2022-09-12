package com.hameroff.api.model.database

import com.hameroff.api.enums.UserRank
import java.sql.Timestamp
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "hameroff_users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,

    var rank: UserRank = UserRank.CLIENT,

    var picture: String? = null,

    @Email
    var mail: String? = null,

    @Size(min = 12, max = 200)
    @NotNull
    var password: String? = null,

    var token: String? = null,

    @Size
    @Column(name = "shop_id")
    var shopId: Integer? = null,

    @Size(min = 2)
    @Column(name = "firstname")
    var firstName: String? = null,

    @Size(min = 2)
    @Column(name = "lastname")
    var lastName: String? = null,

    @Column(name = "verified_at")
    var verifiedAt: Timestamp? = null,

    @Column(name = "created_at")
    var createdAt: Timestamp? = null,

    @Column(name = "deleted_at")
    var deletedAt: Timestamp? = null,
)