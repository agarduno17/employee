package com.test.ms.employee.application.port.out;

import com.test.ms.employee.adapters.out.persistence.sql.entity.EmployeeEntity;
import com.test.ms.employee.domain.Employee;

import java.util.List;

public interface DbPort<T> {
    T save(Employee employee);
    T findById(Long id);
    List<T> findAll();
    T update(EmployeeEntity employeeEntity);
    void deleteById(Long id);
}
