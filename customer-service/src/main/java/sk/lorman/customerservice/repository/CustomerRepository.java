package sk.lorman.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.lorman.customerservice.domain.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
