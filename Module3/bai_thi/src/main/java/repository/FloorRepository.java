package repository;

import connection.ConnectionSQL;
import model.Floor;
import model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FloorRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String SELECT_TYPE_LIST = " select * from floor ";

    public List<Floor> getListFloor() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<Floor> floorList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("floor_id");
                Integer number = resultSet.getInt("floor_number");
                floorList.add(new Floor(id,number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return floorList;
    }
}
