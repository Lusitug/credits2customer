package estudo.credits.credits2customer.projection

import estudo.credits.credits2customer.model.entity.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditListProjection(
    var creditCode: UUID,
    var creditValue: BigDecimal,
    var numberOfInstallment: Int
) {
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallments
    )
}