package sk.lorman.customerservice.service;

import sk.lorman.customerservice.domain.CustomerDTO;

import java.util.Collection;

public interface CustomerService {

    Collection<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(final Long id);

    CustomerDTO createCustomer(final CustomerDTO customerDTO);

    CustomerDTO updateCustomer(final CustomerDTO customerDTO);

    void deleteCustomer(final CustomerDTO customerDTO);
}
