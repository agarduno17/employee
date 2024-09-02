package com.test.ms.employee.application.port.in;

import com.test.ms.employee.domain.Employee;

import java.util.List;

public interface EmployeePort {
    <T> T createEmployee(Employee domainEmployee);
    <T> T getEmployeeById(Long id);
    <T> List<T> getAllEmployees();
    <T> T updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
