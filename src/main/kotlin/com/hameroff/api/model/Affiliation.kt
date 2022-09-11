package com.hameroff.api.model


import javax.persistence.*

@Entity
@Table(name = "hameroff_affiliation")
data class Affiliation(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var name: String? = null,
    var url: String? = null,
)