package estudo.credits.credits2customer.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column(nullable = false)
    var street: String = "",
    @Column(nullable = false)
    var zipCode: String = "",
)