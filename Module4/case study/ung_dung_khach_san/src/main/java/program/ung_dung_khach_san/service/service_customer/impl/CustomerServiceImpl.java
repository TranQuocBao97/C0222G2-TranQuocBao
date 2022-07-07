package program.ung_dung_khach_san.service.service_customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.repository.repository_customer.ICustomerRepository;
import program.ung_dung_khach_san.service.service_customer.ICustomerService;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByName(String name, Pageable pageable) {
        return iCustomerRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return iCustomerRepository.existsById(id);
    }

}
