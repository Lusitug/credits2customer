package estudo.credits.credits2customer.model.entity

import estudo.credits.credits2customer.model.Address
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.math.BigDecimal

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
data class Customer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    var firstName: String? = "",
    @Column(nullable = false)
    var lastName: String? = "",
    @Column(nullable = false)
    var cpf: String? = "",
    @Column(nullable = false)
    var email: String? = "",
    @Column(nullable = false)
    var password: String? = "",
    @Column(nullable = false) @Embedded
    var address: Address = Address(),
    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    @OneToMany(mappedBy = "customer", cascade = [(CascadeType.REMOVE)], fetch = FetchType.LAZY)
    var credits: List<Credit> = mutableListOf(),
    ){
    override fun toString(): String {
        return "Customer(id=$id, firstName='$firstName', lastName='$lastName', cpf='$cpf', email='$email', password='$password', income=$income)"
    }
}
