package sk.lorman.pporderspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.lorman.pporderspring.domain.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
