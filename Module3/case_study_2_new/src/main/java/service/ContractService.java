package service;

import modelDTO.ContractDTO;
import repository.ContractRepository;
import repository.interface_customer_repository.IContractRepository;
import service.interface_service.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    IContractRepository iContractRepository = new ContractRepository();

    @Override
    public List<ContractDTO> getListContractDTO() {
        return iContractRepository.getListContractDTO();
    }
}
