package service;

import model.RentType;
import repository.RentTypeRepository;
import repository.interface_customer_repository.IRentTypeRepository;
import service.interface_service.IRentType;

import java.util.List;

public class RentTypeService implements IRentType {
    IRentTypeRepository iRentTypeRepository = new RentTypeRepository();
    @Override
    public List<RentType> getListRentType() {
        return iRentTypeRepository.getListRentType();
    }
}
