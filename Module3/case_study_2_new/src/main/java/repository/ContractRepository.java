package repository;

import modelDTO.ContractDTO;
import repository.interface_customer_repository.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    ConnectionSQL connectionSQL = new ConnectionSQL();

    private static final String SELECT_CONTRACT = "select * from contract";



    @Override
    public List<ContractDTO> getListContractDTO() {
        Connection connection = connectionSQL.getConnectionJavaToMySQL();
        List<ContractDTO> contractDTOList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("contract_id");
                String startDate =  resultSet.getString("contract_start_date");
                String endDate = resultSet.getString("contract_end_date");
                String deposit = resultSet.getString("contract_deposit");
                String employeeId = resultSet.getString("employee_id");
                String customerId = resultSet.getString("customer_id");
                String serviceId = resultSet.getString("service_id");
                contractDTOList.add(new ContractDTO(id,startDate,endDate,deposit,employeeId,customerId,serviceId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contractDTOList;
    }
}
