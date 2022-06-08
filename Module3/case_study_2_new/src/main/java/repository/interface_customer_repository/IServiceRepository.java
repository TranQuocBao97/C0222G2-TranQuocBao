package repository.interface_customer_repository;

import model.Service;

import java.util.List;

public interface IServiceRepository {
    boolean addNewService(Service service);
    List<Service> getAllService();
}
