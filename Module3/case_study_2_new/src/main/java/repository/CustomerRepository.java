package repository;

import model.Customer;
import repository.interface_customer_repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String SELECT_ALL_CUSTOMER = "select * from customer;";
    private static final String INSERT_CUSTOMER = "INSERT INTO customer (customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id)" +
            "VALUES  (?,?,?,?,?,?,?,?)";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?";
    private static final String EDIT_CUSTOMER = "update customer set customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card = ?,customer_phone = ?,customer_email = ?,customer_address = ?,customer_type_id = ? where customer_id=?";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?";


    @Override
    public List<Customer> getAllCustomerMySQL() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = this.connectionSQL.getConnectionJavaToMySQL();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                Integer typeId = resultSet.getInt("customer_type_id");
                customerList.add(new Customer(id, name, birthday, gender, idCard, phone, email, address, typeId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public boolean addCustomerToDB(Customer customer) {
        Connection connection = this.connectionSQL.getConnectionJavaToMySQL();
        boolean checkCustomerAdded = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getTypeId());
            checkCustomerAdded = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkCustomerAdded;
    }

    @Override
    public boolean deleteCustomer(Integer idCustomerForDelete) {
        Connection connection = this.connectionSQL.getConnectionJavaToMySQL();
        boolean checkCustomerDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1,idCustomerForDelete);
            checkCustomerDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return checkCustomerDelete;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        Connection connection = this.connectionSQL.getConnectionJavaToMySQL();
        boolean checkEditCustomer = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setInt(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getTypeId());
            preparedStatement.setInt(9,customer.getId());
            checkEditCustomer = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkEditCustomer;
    }

    @Override
    public List<Customer> searchByNameCustomer(String nameSearch) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1,"%"+nameSearch+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                Integer typeId = resultSet.getInt("customer_type_id");
                customerList.add(new Customer(id, name, birthday, gender, idCard, phone, email, address, typeId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

}
