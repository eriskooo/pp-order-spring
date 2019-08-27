package sk.lorman.customerservice.domain;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO convertToCustomerDTO(CustomerEntity customerEntity);

    CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO);
}
