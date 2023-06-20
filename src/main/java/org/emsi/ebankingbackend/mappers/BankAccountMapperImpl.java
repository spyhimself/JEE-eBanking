package org.emsi.ebankingbackend.mappers;

import org.emsi.ebankingbackend.dtos.CustomerDTO;
import org.emsi.ebankingbackend.entities.Customer;
import org.springframework.beans.BeanUtils;

public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

}
