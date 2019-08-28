package sk.lorman.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sk.lorman.customerservice.domain.CustomerEntity;
import sk.lorman.customerservice.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {
            repository.save(CustomerEntity.builder().email("email").name("name").build());
        };
    }
}
