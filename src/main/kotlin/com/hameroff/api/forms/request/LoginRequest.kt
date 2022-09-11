package com.hameroff.api.forms.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LoginRequest(

    @NotNull @Email  @Size(min = 5, max = 50)
    var mail: String? = null,

    @NotNull @Size(min = 5, max = 10)
    var password: String? = null
) : IRequest