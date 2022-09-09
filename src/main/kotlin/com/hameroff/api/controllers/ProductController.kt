package com.hameroff.api.controllers

import com.hameroff.api.model.Product
import com.hameroff.api.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/products")
class ProductController @Autowired constructor(val service: ProductService) {

    @GetMapping("")
    fun getAllProducts() = service.getAllProducts()

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long) = service.getProductById(id)


    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveProduct(@RequestBody form: RegisterForm): Product = service.createProduct(form)

    fun removeProduct(@PathVariable id: Long) = service.deleteById(id)

     */

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: Long, @RequestBody product: Product
    ) = service.updateProduct(id, product)
}

