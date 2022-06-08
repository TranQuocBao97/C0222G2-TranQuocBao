package repository;

import model.EducationDegree;
import model.RentType;
import repository.interface_customer_repository.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String SELECT_ALL_EDUCATION = "select * from education_degree";

    @Override
    public List<EducationDegree> getListEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = connectionSQL.getConnectionJavaToMySQL();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer educationId = resultSet.getInt("education_degree_id");
                String educationName = resultSet.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(educationId,educationName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeList;
    }
}
