package sk.lorman.pporderspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sk.lorman.pporderspring.domain.CustomerDTO;

@Slf4j
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "api/v1/customers";

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getAllCustomers() {
        CustomerDTO customerDTO = CustomerDTO.builder().id(1l).name("astar").email("astar@seran.sk").build();

        log.info("getAllCustomers {}", customerDTO);

        return customerDTO;
    }
}
