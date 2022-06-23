package program.quan_ly_khach_hang_phan_trang_tim_kiem.service;

import program.quan_ly_khach_hang_phan_trang_tim_kiem.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAllCustomer ();
    void addCustomer(Customer customer);
}
