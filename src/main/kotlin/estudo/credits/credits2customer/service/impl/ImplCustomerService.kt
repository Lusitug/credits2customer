package estudo.credits.credits2customer.service.impl

import estudo.credits.credits2customer.exceptions.BusinessException
import estudo.credits.credits2customer.model.entity.Customer
import estudo.credits.credits2customer.repository.CustomerRepository
import estudo.credits.credits2customer.service.ItfCustomerService
import org.springframework.stereotype.Service

@Service
class ImplCustomerService(private val customerRepository: CustomerRepository): ItfCustomerService{
    override fun save(customer: Customer): Customer = customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow{
            throw BusinessException("ID $id does not exist")
        }


    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}