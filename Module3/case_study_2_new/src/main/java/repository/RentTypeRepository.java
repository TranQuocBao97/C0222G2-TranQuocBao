package repository;

import model.RentType;
import model.ServiceType;
import repository.interface_customer_repository.IRentTypeRepository;
import repository.interface_customer_repository.IServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String SELECT_ALL_RENT_TYPE = "select * from rent_type";

    @Override
    public List<RentType> getListRentType() {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = connectionSQL.getConnectionJavaToMySQL();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                rentTypeList.add(new RentType(rentTypeId,rentTypeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }


}
