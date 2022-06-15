package repository;

import connection.ConnectionSQL;
import model.Status;
import model.Type;
import repository.interface_repository.ITypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeRepository implements ITypeRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();


    private static final String SELECT_TYPE_LIST = " select * from type_land ";
    @Override
    public List<Type> getListType() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<Type> typeList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("type_id");
                String name = resultSet.getString("type_name");
                typeList.add(new Type(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return typeList;
    }
}
