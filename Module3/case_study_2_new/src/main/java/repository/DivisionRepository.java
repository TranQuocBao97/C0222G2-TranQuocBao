package repository;

import model.Division;
import repository.interface_customer_repository.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String SELECT_ALL_DIVISION = "select * from division";

    @Override
    public List<Division> getListDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = connectionSQL.getConnectionJavaToMySQL();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                divisionList.add(new Division(divisionId,divisionName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }
}
