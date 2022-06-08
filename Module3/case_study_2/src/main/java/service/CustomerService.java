package service;

import model.Customer;
import repository.CustomerRepository;
import repository.interface_customer_repository.ICustomerRepository;
import service.interface_service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public List<Customer> getAllCustomer() {
       return iCustomerRepository.getAllCustomerMySQL();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return iCustomerRepository.addCustomerToDB(customer);
    }

    @Override
    public boolean deleteCustomer(Integer idCustomerForDelete) {
        return iCustomerRepository.deleteCustomer(idCustomerForDelete);
    }

    @Override
    public boolean editCustomerByID(Customer customer) {
        return iCustomerRepository.editCustomer(customer);
    }

    @Override
    public List<Customer> searchByNameCustomer(String nameSearch) {
        return iCustomerRepository.searchByNameCustomer(nameSearch);
    }
}
