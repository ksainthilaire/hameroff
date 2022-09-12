package com.hameroff.api.repositories

import com.hameroff.api.model.database.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IOrderRepository : JpaRepository<Order, Long>