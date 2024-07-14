package estudo.credits.credits2customer.dto

import estudo.credits.credits2customer.model.Address
import estudo.credits.credits2customer.model.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO(
    @field:NotBlank(message = "Invalid Field(First Name).") var firstName: String,
    @field:NotBlank(message = "Invalid Field(Last Name).") var lastName: String,
    @field:NotBlank(message = "Invalid Field(CPF).") @field:CPF var cpf: String,
    @field:NotBlank(message = "Invalid Field(E-mail).") @field:Email(message = "Invalid E-mail.") var email: String,
    @field:NotBlank(message = "Invalid Field(Password)") var password: String,
    @field:NotBlank(message = "Invalid Field(Income)") var income: BigDecimal,
    @field:NotBlank(message = "Invalid Field(Zip Code)")var zipCode: String,
    @field:NotBlank(message = "Invalid Field(Street)") var street: String
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email = this.email,
        income = this.income,
        password = this.password,
        address = Address(street=this.street,zipCode=this.zipCode,)
    )
}
