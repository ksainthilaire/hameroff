package com.hameroff.api.repositories

import com.hameroff.api.model.database.UserAddress
import org.springframework.data.jpa.repository.JpaRepository

interface IUserAddressRepository : JpaRepository<UserAddress, Long>