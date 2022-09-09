package com.hameroff.api.repositories

import com.hameroff.api.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IProductRepository : JpaRepository<Product, Long>