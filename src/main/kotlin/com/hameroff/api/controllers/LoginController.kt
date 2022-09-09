package com.hameroff.api.controllers

import com.hameroff.api.forms.request.LoginRequest
import com.hameroff.api.forms.request.LogoutRequest
import com.hameroff.api.services.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class LoginController @Autowired constructor(val service: LoginService) {

    @PostMapping("/api/v1/login")
    fun login(@RequestBody @Valid request: LoginRequest) : ResponseEntity<Any> = service.login(request)

    @PostMapping("/api/v1/logout")
    fun login(@RequestBody @Valid request: LogoutRequest) : ResponseEntity<Any> = service.logout(request)



}

