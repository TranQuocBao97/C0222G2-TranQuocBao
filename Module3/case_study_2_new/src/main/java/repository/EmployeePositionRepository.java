package repository;

import model.EmployeePosition;
import model.RentType;
import repository.interface_customer_repository.IEmployeePositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeePositionRepository implements IEmployeePositionRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String SELECT_ALL_EMPLOYEE_POSITION = "select * from employee_position";


    @Override
    public List<EmployeePosition> getListEmployeePosition() {
        List<EmployeePosition> employeePositionList = new ArrayList<>();
        Connection connection = connectionSQL.getConnectionJavaToMySQL();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer positionId = resultSet.getInt("employee_position_id");
                String positionName = resultSet.getString("employee_position_name");
                employeePositionList.add(new EmployeePosition(positionId,positionName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeePositionList;
    }
}
