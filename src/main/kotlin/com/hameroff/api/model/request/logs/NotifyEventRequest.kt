package com.hameroff.api.model.request.logs

import com.hameroff.api.model.request.base.IRequest

data class NotifyEventRequest(
    var syslog: String
) : IRequest