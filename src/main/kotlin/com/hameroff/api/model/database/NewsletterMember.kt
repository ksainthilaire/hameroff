package com.hameroff.api.model.database

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "hameroff_newsletter_members")
data class NewsletterMember(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var mail: String? = null,

    @Column(name = "created_at")
    var createdAt: Timestamp? = null,

    @Column(name = "deleted_at")
    var deletedAt: Timestamp? = null,
)
