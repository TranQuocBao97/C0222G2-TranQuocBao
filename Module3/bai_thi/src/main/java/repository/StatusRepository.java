package repository;

import connection.ConnectionSQL;
import model.Land;
import model.Status;
import repository.interface_repository.IStatusRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusRepository implements IStatusRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();


    private static final String SELECT_STATUS_LIST = " select * from status ";

    @Override
    public List<Status> getListStatus() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<Status> statusList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATUS_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("status_id");
                String name = resultSet.getString("status_name");
                statusList.add(new Status(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statusList;
    }
}
