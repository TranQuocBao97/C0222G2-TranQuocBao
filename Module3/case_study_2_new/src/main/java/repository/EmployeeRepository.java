package repository;

import model.Employee;
import modelDTO.EmployeeDTO;
import repository.interface_customer_repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeRepository implements IEmployeeRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String INSERT_EMPLOYEE = " insert into employee (employee_name,employee_birthday,employee_id_card,employee_salary, " +
            " employee_phone,employee_email,employee_address,employee_position_id,education_degree_id, " +
            " division_id) value (?,?,?,?,?,?,?,?,?,?) ";
    private static final String SELECT_ALL_EMPLOYEE = " select employee.* , employee_position.employee_position_name , education_degree.education_degree_name , division.division_name from employee " +
            " inner join employee_position on employee.employee_position_id = employee_position.employee_position_id " +
            " inner join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            " inner join division on employee.division_id = division.division_id ";

    private static final String DELETE_EMPLOYEE ="delete from employee where employee_id = ?";

    private static final String EDIT_EMPLOYEE = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card=?, employee_salary=?,employee_phone=?, employee_email=?, employee_address=?,employee_position_id=?, education_degree_id=?,division_id=? where employee_id=?";

    private static final String SEARCH_EMPLOYEE = "select employee.* , employee_position.employee_position_name , education_degree.education_degree_name , division.division_name from employee " +
            " inner join employee_position on employee.employee_position_id = employee_position.employee_position_id " +
            " inner join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            " inner join division on employee.division_id = division.division_id " +
            " where employee.employee_id like ? and employee.employee_name like ? and  employee.employee_position_id like ?  and employee.division_id like ?; " ;
    
    @Override
    public boolean addEmployee(Employee employee) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        boolean checkEmployeeAdded = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getEmployeePosition().getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegree().getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivision().getDivisionId());
            checkEmployeeAdded = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return checkEmployeeAdded;
    }

    @Override
    public List<EmployeeDTO> getAllEmployeeDTO() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String positionName = resultSet.getString("employee_position_name");
                String educationName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                employeeDTOList.add(new EmployeeDTO(id,name,birthday,idCard,salary,phone,email,
                        address,positionName,educationName,divisionName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeDTOList;
    }

    @Override
    public boolean deleteEmployeeById(Integer id) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        boolean checkEmployeeDelete = false;

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1,id);
            checkEmployeeDelete = preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkEmployeeDelete;
    }

    @Override
    public boolean editEmployee(Employee employee) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        boolean checkEdit = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_EMPLOYEE);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8,employee.getEmployeePosition().getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegree().getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivision().getDivisionId());
            preparedStatement.setInt(11,employee.getId());
            checkEdit = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkEdit;
    }

    @Override
    public List<EmployeeDTO> searchAllEmployeeDTO(String searchId, String searchName, String searchPosition, String searchDivision) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE)){
            preparedStatement.setString(1,"%"+searchId+"%");
            preparedStatement.setString(2,"%"+searchName+"%");
            preparedStatement.setString(3,"%"+searchPosition+"%");
            preparedStatement.setString(4,"%"+searchDivision+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String positionName = resultSet.getString("employee_position_name");
                String educationName = resultSet.getString("education_degree_name");
                String divisionName = resultSet.getString("division_name");
                employeeDTOList.add(new EmployeeDTO(id,name,birthday,idCard,salary,phone,email,
                        address,positionName,educationName,divisionName));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDTOList;
    }
}
