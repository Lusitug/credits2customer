package estudo.credits.credits2customer.projection

import estudo.credits.credits2customer.model.entity.Customer
import java.math.BigDecimal

data class CustomerProjection(
    var firstName: String,
    var lastName: String,
    var cpf: String,
    var email: String,
    var income: BigDecimal,
    var zipCode: String,
    var street: String
) {
    constructor(customer: Customer): this(
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )
}