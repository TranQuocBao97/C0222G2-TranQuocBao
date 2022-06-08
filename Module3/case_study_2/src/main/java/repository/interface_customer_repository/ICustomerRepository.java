package repository.interface_customer_repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    public List<Customer> getAllCustomerMySQL();

    boolean addCustomerToDB(Customer customer);

    boolean deleteCustomer(Integer idCustomerForDelete);

    boolean editCustomer(Customer customer);

    List<Customer> searchByNameCustomer(String nameSearch);
}
