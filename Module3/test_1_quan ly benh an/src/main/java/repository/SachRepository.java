package repository;

import modal.Sach;
import modal.TheMuonSach;
import repository.interface_repository.ISachRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepository implements ISachRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();

    private static final String SELECT_SACH = " select * from sach ";
    private static final String UPDATE_TRU_SACH = "update sach set so_luong = so_luong - 1 where ma_sach = ?";



    @Override
    public List<Sach> getAllSach() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<Sach> sachList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SACH)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("ma_sach");
                String name = resultSet.getString("ten_sach");
                String writer = resultSet.getString("tac_gia");
                String information = resultSet.getString("mo_ta");
                String number = resultSet.getString("so_luong");
                sachList.add(new Sach(id,name,writer,information,number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sachList;
    }

    @Override
    public void updateTruSoLuongSach(String sachId) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TRU_SACH)) {
            preparedStatement.setString(1,sachId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
