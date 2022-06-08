package repository;

import model.ServiceType;
import repository.interface_customer_repository.IServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String SELECT_ALL_SERVICE_TYPE = "select * from service_type";


    @Override
    public List<ServiceType> getListServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = connectionSQL.getConnectionJavaToMySQL();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(serviceTypeId,serviceTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return serviceTypeList;
    }
}
