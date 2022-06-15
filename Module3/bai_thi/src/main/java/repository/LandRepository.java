package repository;

import connection.ConnectionSQL;
import model.Land;
import repository.interface_repository.ILandRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LandRepository implements ILandRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();


    private static final String SELECT_LAND_LIST = " select * from land ";
    private static final String INSERT_LAND = " insert into land (id,area,status_id,floor_number,type_id,information,price,dateStart,dateEnd) value (?,?,?,?,?,?,?,?,?) ";


    @Override
    public List<Land> getLandList() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<Land> landList = new ArrayList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAND_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                Double area = resultSet.getDouble("area");
                Integer statusId = resultSet.getInt("status_id");
                Integer floorNumber = resultSet.getInt("floor_number");
                Integer typeId = resultSet.getInt("type_id");
                String information = resultSet.getString("information");
                Double price = resultSet.getDouble("price");
                String dateStart = resultSet.getString("dateStart");
                String dateEnd = resultSet.getString("dateEnd");
                landList.add(new Land(id,area,statusId,floorNumber,typeId,information,price,dateStart,dateEnd));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return landList;
    }

    @Override
    public boolean insertLand(Land land) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        boolean checkAddLand = false;
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LAND)){
            preparedStatement.setString(1,land.getId());
            preparedStatement.setDouble(2,land.getArea());
            preparedStatement.setInt(3,land.getStatusId());
            preparedStatement.setInt(4,land.getFloorNumber());
            preparedStatement.setInt(5,land.getTypeId());
            preparedStatement.setString(6,land.getInformation());
            preparedStatement.setDouble(7,land.getPrice());
            preparedStatement.setString(8,land.getDateStart());
            preparedStatement.setString(9,land.getDateEnd());
            checkAddLand = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return checkAddLand;
    }
}
