package program.ung_dung_khach_san.service.service_employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_employee.Employee;
import program.ung_dung_khach_san.repository.repository_employee.IEmployeeRepository;
import program.ung_dung_khach_san.service.service_employee.IEmployeeService;

@Repository
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByNameContaining(String name, Pageable pageable) {
        return iEmployeeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void deleteById(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }
}
