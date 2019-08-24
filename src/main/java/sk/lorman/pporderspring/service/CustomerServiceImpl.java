package sk.lorman.pporderspring.service;

import org.springframework.stereotype.Service;
import sk.lorman.pporderspring.domain.CustomerDTO;
import sk.lorman.pporderspring.domain.CustomerEntity;
import sk.lorman.pporderspring.domain.CustomerMapper;
import sk.lorman.pporderspring.exceptions.ResourceNotFoundException;
import sk.lorman.pporderspring.repository.CustomerRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper customerMapper;
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public Collection<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(e -> customerMapper.convertToCustomerDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {

        return customerRepository.findById(id)
                .map(customerMapper::convertToCustomerDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerEntity entity = customerRepository.save(customerMapper.convertToCustomerEntity(customerDTO));
        return customerMapper.convertToCustomerDTO(entity);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(CustomerDTO customerDTO) {

    }
}
