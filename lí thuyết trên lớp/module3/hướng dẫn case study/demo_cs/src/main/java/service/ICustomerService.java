package service;

import model.Customer;
import model.CustomerType;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    List<Customer> searchByName(String name);

    void save(Customer customer);

    Customer findById(int id);

    void edit(Customer customer);
    List<CustomerType> findAllCustomerType();

}
