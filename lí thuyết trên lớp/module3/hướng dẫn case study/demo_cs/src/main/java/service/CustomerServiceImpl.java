package service;

import model.Customer;
import model.CustomerType;
import repository.CustomerRepositoryImpl;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    private ICustomerRepository iCustomerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void edit(Customer customer) {

    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return iCustomerRepository.findAllCustomerType();
    }
}
