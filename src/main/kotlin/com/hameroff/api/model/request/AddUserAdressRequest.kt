package com.hameroff.api.model.request

import com.hameroff.api.model.database.UserAddress

data class AddUserAddressRequest(
    var address: UserAddress
) : IRequest