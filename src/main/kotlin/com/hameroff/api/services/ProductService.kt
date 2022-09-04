package com.hameroff.api.services
import com.hameroff.api.model.Product
import com.hameroff.api.repositories.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductService(val productRepository: ProductRepository) {

    fun getAllProducts(): List<Product> = productRepository.findAll()

    fun getProductById(id: Long): Product = productRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun createProduct(product: Product): Product = productRepository.save(product)

    fun updateProduct(id: Long, Product: Product) {
        if (productRepository.existsById(id)) {
            Product.id = id
            productRepository.save(Product)
        }
    }

    fun refundOrder(id: Long) {}

    fun getOrderById(id: Long) {}
    fun getOrderByUserId(userId: Long) {}

    fun createTransaction() {}
    fun updateTransaction() {}
    fun removeTransaction() {}

    fun startPayment() {}
    fun cancelPayment() {}
    fun getPaymentStatus() {}

    fun createInvoice() {}
    fun revokeInvoice() {}
    fun getInvoice() {}


}