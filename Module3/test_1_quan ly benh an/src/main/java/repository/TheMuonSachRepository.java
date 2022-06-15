package repository;

import modal.TheMuonSach;
import repository.interface_repository.ITheMuonSachRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheMuonSachRepository implements ITheMuonSachRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();
    private static final String INSERT_THE_MUON_SACH = " insert into the_muon_sach (ma_muon_sach,trang_thai,ngay_muon,ngay_tra,ma_hoc_sinh,ma_sach) value (?,?,?,?,?,?) ";
    private static final String SELECT_THE_MUON_SACH = "select * from the_muon_sach";

    @Override
    public List<TheMuonSach> getListTheMuonSach() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<TheMuonSach> theMuonSachList = new ArrayList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THE_MUON_SACH)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("ma_muon_sach");
                String ngayMuon =resultSet.getString("ngay_muon");
                String ngayTra = resultSet.getString("ngay_tra");
                String maHocSinh = resultSet.getString("ma_hoc_sinh");
                String maSach = resultSet.getString("ma_sach");
                theMuonSachList.add(new TheMuonSach(id,ngayMuon,ngayTra,maHocSinh,maSach));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return theMuonSachList;
    }

    @Override
    public boolean addTheMuonSach(TheMuonSach theMuonSach) {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        boolean checkAdd = false;
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THE_MUON_SACH)) {
            preparedStatement.setString(1,theMuonSach.getId());
            preparedStatement.setString(2,"1");
            preparedStatement.setString(3,theMuonSach.getDateStart());
            preparedStatement.setString(4,theMuonSach.getDateEnd());
            preparedStatement.setString(5,theMuonSach.getHocSinhId());
            preparedStatement.setString(6, theMuonSach.getSachId());
            checkAdd = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return checkAdd;
    }


}
