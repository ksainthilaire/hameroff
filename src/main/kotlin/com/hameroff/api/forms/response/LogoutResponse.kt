package com.hameroff.api.forms.response

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LogoutResponse (

    @NotNull
    var status: String? = null,
)