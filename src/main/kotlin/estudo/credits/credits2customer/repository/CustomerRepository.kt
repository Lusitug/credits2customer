package estudo.credits.credits2customer.repository

import estudo.credits.credits2customer.model.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
interface CustomerRepository: JpaRepository<Customer, Long> {

}