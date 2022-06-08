package repository;

import model.RentType;
import model.Service;
import model.ServiceType;
import repository.interface_customer_repository.IServiceRepository;
import service.interface_service.IService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String INSERT_SERVICE = "insert into service (service_name,service_area,service_cost,service_max_people,standard_room,description_other_convenience,pool_area,number_of_floors,rent_type_id,service_type_id)" +
            "value (?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_SERVICE = "select * from service";


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

    @Override
    public List<Service> getAllService() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<Service> serviceList = new ArrayList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                Double area = resultSet.getDouble("service_area");
                Double cost = resultSet.getDouble("service_cost");
                Integer maxPeople = resultSet.getInt("service_max_people");
                String standard = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                Double areaPool = resultSet.getDouble("pool_area");
                Integer floors = resultSet.getInt("number_of_floors");
                Integer rentTypeId = resultSet.getInt("rent_type_id");
                Integer serviceTypeId = resultSet.getInt("service_type_id");
                serviceList.add(new Service(id,name,area,cost,maxPeople,standard,description,areaPool,floors,new RentType(rentTypeId),new ServiceType(serviceTypeId)));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }
}
