package repository;

import model.Customer;
import model.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository{
    public final String FIND_ALL = " select * from customer " ;
    public final String FIND_ALL_CUSTOMER_TYPE = " select * from customer_type " ;

    @Override
    public List<CustomerType> findAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();

//       try-with-resources
        try (Connection connection = new ConnectionDB().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                CustomerType customerType = new CustomerType(id, name);
                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customerTypeList;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();

//       try-with-resources
        try (Connection connection = new ConnectionDB().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int gender = resultSet.getInt("gender");
                String birthday = resultSet.getString("birthday");
                int customerTypeId = resultSet.getInt("customer_type_id");
                Customer customer = new Customer(id, name, gender, birthday, customerTypeId);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return customerList;
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
}
