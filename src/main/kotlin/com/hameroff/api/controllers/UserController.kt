package com.hameroff.api.controllers

import com.hameroff.api.model.request.AddUserAddressRequest
import com.hameroff.api.model.request.RegisterRequest
import com.hameroff.api.model.database.User
import com.hameroff.api.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/users")
class UserController @Autowired constructor(val service: UserService) {

    @GetMapping("")
    fun getAllUsers() = service.getAllUsers()

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long) = service.getUserById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody form: RegisterRequest): User = service.createUser(form)

    @PutMapping("/{id}")
    fun updateUser(
        @PathVariable id: Long, @RequestBody User: User
    ) = service.updateUser(id, User)

    @PostMapping("/{id}/address")
    fun addUserAddress(@PathVariable id: Long, @RequestBody address: AddUserAddressRequest) = service.addUserAddress(id, address)
}