package program.app.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.app.model.Contract;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);
}
