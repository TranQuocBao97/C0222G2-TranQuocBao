package repository;

import modal.HocSinh;
import repository.interface_repository.IHocSinhRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocSinhRepository implements IHocSinhRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String SELECT_HOC_SINH = "select * from hoc_sinh";

    @Override
    public List<HocSinh> getListHocSinh() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<HocSinh> hocSinhList = new ArrayList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOC_SINH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("ma_hoc_sinh");
                String name = resultSet.getString("ho_ten");
                String lop = resultSet.getString("lop");
                hocSinhList.add(new HocSinh(id,name,lop));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hocSinhList;
    }
}
