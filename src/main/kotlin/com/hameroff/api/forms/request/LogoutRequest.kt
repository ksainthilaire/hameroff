package com.hameroff.api.forms.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LogoutRequest(
    @NotNull
    var mail: String? = null,
)