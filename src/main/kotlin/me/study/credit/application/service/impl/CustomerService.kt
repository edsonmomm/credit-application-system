package me.study.credit.application.service.impl

import me.study.credit.application.exception.BusinessException
import me.study.credit.application.model.Customer
import me.study.credit.application.model.dto.request.CustomerUpdateDTO
import me.study.credit.application.repository.CustomerRepository
import me.study.credit.application.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {

    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("Customer with Id $id was not found.")
        }
    }

    override fun delete(id: Long) {
        this.findById(id)
        this.customerRepository.deleteById(id)
    }

    fun updateCustomer(id: Long, customerUpdateDTO: CustomerUpdateDTO) : Customer {
        val customer: Customer = this.findById(id)
        val customerToUpdate: Customer = customerUpdateDTO.toEntity(customer)
        return this.save(customerToUpdate)
    }
}