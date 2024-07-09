package estudo.credits.credits2customer.service

import estudo.credits.credits2customer.model.entity.Credit
import java.util.UUID

interface ItfCreditService {
    //save
    fun save(credit: Credit): Credit
    //findAllByCustomer
    fun findAllByCustomer(customerId: Long): List<Credit>
    //findByCreditCode
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}
