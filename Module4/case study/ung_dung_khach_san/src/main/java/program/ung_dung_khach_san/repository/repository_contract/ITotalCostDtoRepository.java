package program.ung_dung_khach_san.repository.repository_contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.dto.TotalCostDTO;

import java.util.List;

@Repository
public interface ITotalCostDtoRepository extends JpaRepository<TotalCostDTO,Integer> {
    @Query(value = "select contract.contract_id, (TIMESTAMPDIFF(day, contract.start_date, contract.end_date))*facility.cost+ifnull(total_cost_other_service,0) as total_cost " +
            " from contract inner join facility on contract.facility_id = facility.facility_id " +
            " left join " +
            " (select contract_other_service.contract_id, sum(other_service.cost*contract_other_service.amount) as total_cost_other_service " +
            " from other_service inner join contract_other_service " +
            " on other_service.other_service_id = contract_other_service.other_service_id " +
            " group by contract_id) as table_total_cost_other_service on contract.contract_id = table_total_cost_other_service.contract_id", nativeQuery = true)
    List<TotalCostDTO> selectTotalCost();

}
