package com.hameroff.api.model.request

import com.hameroff.api.model.database.UserAddress
import com.hameroff.api.model.request.base.IRequest

data class AddUserAddressRequest(
    var address: UserAddress
) : IRequest