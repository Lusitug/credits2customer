package estudo.credits.credits2customer.projection

import estudo.credits.credits2customer.model.entity.Credit
import estudo.credits.credits2customer.model.enums.Status
import java.math.BigDecimal
import java.time.LocalDate

data class CreditProjection(
    var creditValue: BigDecimal,
    var dayFirstQuota: LocalDate,
    var numberOfInstallments: Int,
    var status: Status,
    var emailCustomer: String?,
    var incomeCustomer: BigDecimal?
) {
    constructor(credit: Credit): this(
        creditValue = credit.creditValue,
        dayFirstQuota = credit.dayFirstQuota,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomeCustomer = credit.customer?.income
    )
}