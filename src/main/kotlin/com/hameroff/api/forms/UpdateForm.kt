package com.hameroff.api.forms

import com.fasterxml.jackson.annotation.JsonAlias

data class UpdateForm(
    val mail: String? = null,
    val password: String? = null,

    @JsonAlias("firstname")
    val firstName: String? = null,

    @JsonAlias("lastname")
    val lastName: String? = null
)