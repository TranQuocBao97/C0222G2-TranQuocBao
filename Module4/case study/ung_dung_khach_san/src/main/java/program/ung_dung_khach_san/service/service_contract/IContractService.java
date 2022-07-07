package program.ung_dung_khach_san.service.service_contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.ung_dung_khach_san.model.Contract;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

}
