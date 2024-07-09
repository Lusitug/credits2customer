package estudo.credits.credits2customer.repository

import estudo.credits.credits2customer.model.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
@RepositoryRestResource(collectionResourceRel = "credits", path = "credits")
interface CreditRepository: JpaRepository<Credit, Long> {
    //findByCreditCode
    fun findByCreditCode(creditCode: UUID): Credit?
    //findAllByCustomerId
    @Query("SELECT * FROM credit WHERE customer_id=?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>
}