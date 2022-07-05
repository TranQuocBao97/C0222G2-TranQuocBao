package repository;

import model.Customer;
import model.CustomerType;

import java.util.List;

public interface ICustomerRepository {

    List<Customer> findAll();

    List<CustomerType> findAllCustomerType();

    List<Customer> searchByName(String name);

    void save(Customer customer);

    Customer findById(int id);

    void edit(Customer customer);


}
