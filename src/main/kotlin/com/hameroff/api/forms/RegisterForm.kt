package com.hameroff.api.forms

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class RegisterForm(
    @Email
    val mail: String,

    @Size(min = 12, max = 200)
    @NotNull
    val password: String,

    @JsonAlias("firstname")
    val firstName: String,

    @JsonAlias("lastname")
    val lastName: String
)