package program.quan_ly_khach_hang_phan_trang_tim_kiem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.model.Customer;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.repository.ICustomerRepository;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.service.ICustomerService;

import java.util.List;


@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return iCustomerRepository.selectAllCustomer();
    }

    @Override
    public void addCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    public Customer getCustomerById(Integer id){
        return iCustomerRepository.getCustomerById(id);
    }
}
