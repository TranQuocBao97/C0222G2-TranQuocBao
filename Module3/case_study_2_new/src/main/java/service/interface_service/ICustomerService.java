package service.interface_service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getAllCustomer();

    boolean addCustomer(Customer customer);

    boolean deleteCustomer(Integer idCustomerForDelete);

    boolean editCustomerByID(Customer customer);

    List<Customer> searchByNameCustomer(String nameSearch);
}
