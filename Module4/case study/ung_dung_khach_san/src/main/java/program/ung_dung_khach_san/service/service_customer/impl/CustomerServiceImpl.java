package program.ung_dung_khach_san.service.service_customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.repository.repository_customer.ICustomerRepository;
import program.ung_dung_khach_san.service.service_customer.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }
}
