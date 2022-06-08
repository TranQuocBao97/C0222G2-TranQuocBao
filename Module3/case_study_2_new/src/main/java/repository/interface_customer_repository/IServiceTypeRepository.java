package repository.interface_customer_repository;

import model.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> getListServiceType();
}
