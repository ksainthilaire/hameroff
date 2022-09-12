package com.hameroff.api.model.response

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LoginResponse (

    @NotNull @Email  @Size(min = 5, max = 50)
    var mail: String? = null,

    @NotNull
    var accessToken: String? = null

)