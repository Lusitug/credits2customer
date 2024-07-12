package estudo.credits.credits2customer.service.impl

import estudo.credits.credits2customer.exceptions.BusinessException
import estudo.credits.credits2customer.model.entity.Credit
import estudo.credits.credits2customer.repository.CreditRepository
import estudo.credits.credits2customer.service.ItfCreditService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class ImplCreditService(private val creditRepository: CreditRepository,
                        private val customerService: ImplCustomerService): ItfCreditService {

    override fun save(credit: Credit): Credit {
        this.validDayFirstQuota(credit.dayFirstQuota)
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)//customer = customerService.findById(credit.customer?.id ?: throw IllegalArgumentException("Customer ID cannot be null"))
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit = (this.creditRepository.findByCreditCode(creditCode))
            ?: throw Exception("Credit code $creditCode not found")
        return if (credit.customer?.id == customerId) credit else
            throw IllegalArgumentException("Contact Admin!")
    }

    private fun validDayFirstQuota(dayFirstQuota: LocalDate): Boolean {
        return if (dayFirstQuota.isBefore(LocalDate.now().plusMonths(3))) true
        else throw BusinessException("Invalid Date")
    }
}