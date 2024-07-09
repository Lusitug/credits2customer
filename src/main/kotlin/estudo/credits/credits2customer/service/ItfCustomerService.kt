package estudo.credits.credits2customer.service

import estudo.credits.credits2customer.model.entity.Customer

interface ItfCustomerService {
    //save
    fun save(customer: Customer): Customer
    //findById
    fun findById(id: Long): Customer
    //delete
    fun delete(id: Long)
}