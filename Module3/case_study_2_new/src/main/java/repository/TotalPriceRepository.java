package repository;

import model.TotalPrice;
import repository.interface_customer_repository.ITotalPriceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TotalPriceRepository implements ITotalPriceRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();

    private static final String SELECT_TOTAL_PRICE  = " select contract.contract_id, datediff(contract.contract_end_date,contract.contract_start_date)*service.service_cost as total_cost from contract left join service on contract.service_id = service.service_id; ";



    @Override
    public List<TotalPrice> getListTotalPrice() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<TotalPrice> totalPriceList = new ArrayList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TOTAL_PRICE)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("contract_id");
                String totalPrice = resultSet.getString("total_cost");
                totalPriceList.add(new TotalPrice(id,totalPrice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPriceList;
    }
}
