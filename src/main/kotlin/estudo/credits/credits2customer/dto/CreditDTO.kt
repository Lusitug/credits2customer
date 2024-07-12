package estudo.credits.credits2customer.dto

import estudo.credits.credits2customer.model.entity.Credit
import estudo.credits.credits2customer.model.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class CreditDTO(
    @field:NotNull var creditValue: BigDecimal,
    @field:Future var dayFirstQuota: LocalDate,
    @field:Max(value = 48, message = "Max installments exceeded.") var numberOfInstallments: Int,
    @field:NotNull var customerId: Long
)
{
    companion object{
        private const val MAX_INSTALLMENTS = 48
        private const val MAX_FIRST_INSTALLMENT_MONTHS = 3L
    }init {
        require(numberOfInstallments <= MAX_INSTALLMENTS){
            "Max Installments exceeded (48)."
        }
        require(LocalDate.now().until(dayFirstQuota, ChronoUnit.MONTHS) <= MAX_FIRST_INSTALLMENT_MONTHS){
            "First quota date must be within 3 months from today."
        }
    }

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstQuota = this.dayFirstQuota,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}