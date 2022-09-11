package com.hameroff.api.forms.request

import com.hameroff.api.model.UserAddress

data class AddUserAddressRequest(
    var address: UserAddress
) : IRequest