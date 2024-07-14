package estudo.credits.credits2customer.dto

import estudo.credits.credits2customer.model.entity.Customer
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class CustomerUpdateDTO(
    @field:NotBlank(message = "Invalid Field(First Name).") var firstName: String,
    @field:NotBlank(message = "Invalid Field(Last Name).") var lastName: String,
    @field:NotBlank(message = "Invalid Field(Income)") var income: BigDecimal,
    @field:NotBlank(message = "Invalid Field(Zip Code)")var zipCode: String,
    @field:NotBlank(message = "Invalid Field(Street)") var street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode

        return customer
    }
}