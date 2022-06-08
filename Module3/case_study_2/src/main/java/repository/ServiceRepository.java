package repository;

import repository.interface_customer_repository.IServiceRepository;
import service.Service;
import service.interface_service.IService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceRepository implements IServiceRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String INSERT_SERVICE = "insert into service (service_name,service_area,service_cost,service_max_people,standard_room,description_other_convenience,pool_area,number_of_floors,rent_type_id,service_type_id)" +
            "value (?,?,?,?,?,?,?,?,?,?)";


    @Override
    public boolean addNewService(model.Service service) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        boolean checkServiceAdded = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE);
            preparedStatement.setString(1,service.getServiceName());
            preparedStatement.setDouble(2,service.getServiceArea());
            preparedStatement.setDouble(3,service.getServiceCost());
            preparedStatement.setInt(4,service.getServiceMaxPeople());
            preparedStatement.setString(5,service.getServiceStandardRoom());
            preparedStatement.setString(6,service.getServiceDescription());
            preparedStatement.setDouble(7,service.getServicePoolArea());
            preparedStatement.setInt(8,service.getServiceNumberFloor());
            preparedStatement.setInt(9,service.getRentType().getRentTypeId());
            preparedStatement.setInt(10,service.getServiceType().getServiceTypeId());
            checkServiceAdded = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return checkServiceAdded;
    }
}
