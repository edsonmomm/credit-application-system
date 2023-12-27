package me.study.credit.application.controller

import jakarta.validation.Valid
import me.study.credit.application.model.Customer
import me.study.credit.application.model.dto.request.CustomerDTO
import me.study.credit.application.model.dto.request.CustomerUpdateDTO
import me.study.credit.application.model.dto.response.CustomerView
import me.study.credit.application.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDTO: CustomerDTO): ResponseEntity<CustomerView> {
        val savedCustomer = this.customerService.save(customerDTO.toEntity())
        return ResponseEntity(CustomerView(savedCustomer), HttpStatus.CREATED)
    }

    @GetMapping()
    fun findById(@RequestParam(value = "customerId")  id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity(CustomerView(customer), HttpStatus.OK)
    }

    @DeleteMapping()
    fun deleteById(@RequestParam(value = "customerId") id: Long) {
        this.customerService.delete(id)
    }

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId")  id: Long, @RequestBody customerUpdateDTO: CustomerUpdateDTO): ResponseEntity<CustomerView> {
        return ResponseEntity(CustomerView(this.customerService.updateCustomer(id, customerUpdateDTO)), HttpStatus.OK)
    }
}