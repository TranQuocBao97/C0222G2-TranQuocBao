package program.ung_dung_khach_san.repository.repository_contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.ContractOtherService;

import java.util.List;

@Repository
public interface IContractOtherServiceRepository extends JpaRepository<ContractOtherService,Integer> {

    List<ContractOtherService> findAll();

    void deleteContractOtherServicesByContractId(Integer id);
}
