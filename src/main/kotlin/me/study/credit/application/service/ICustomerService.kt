package me.study.credit.application.service

import me.study.credit.application.model.Customer
import java.util.UUID

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}