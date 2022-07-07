package program.ung_dung_khach_san.service.service_contract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.repository.repository_contract.IContractRepository;
import program.ung_dung_khach_san.service.service_contract.IContractService;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }
}
