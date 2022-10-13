package com.hameroff.api.model.request.newsletter

import com.hameroff.api.model.request.base.IRequest


data class SubscribeNewsletterRequest(
    var mail: String
) : IRequest