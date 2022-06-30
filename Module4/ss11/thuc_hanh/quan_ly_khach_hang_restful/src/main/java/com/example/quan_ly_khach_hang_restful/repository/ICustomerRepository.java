package com.example.quan_ly_khach_hang_restful.repository;


import com.example.quan_ly_khach_hang_restful.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
