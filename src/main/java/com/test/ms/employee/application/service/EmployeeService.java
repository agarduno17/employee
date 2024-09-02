package com.test.ms.employee.application.service;

import com.test.ms.employee.adapters.out.persistence.EmployeeMapper;
import com.test.ms.employee.adapters.out.persistence.sql.entity.EmployeeEntity;
import com.test.ms.employee.application.port.in.EmployeePort;
import com.test.ms.employee.application.port.out.DbPort;
import com.test.ms.employee.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeePort {

    private final DbPort dbPort;

    //@Override
    public <T> T createEmployee(Employee domainEmployee) {
        return (T) dbPort.save(domainEmployee);
    }

    public <T> T getEmployeeById(Long id) {
        return (T) dbPort.findById(id);

    }
    public <T> List<T> getAllEmployees() {
        return dbPort.findAll();
    }

    public <T> T updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = getEmployeeById(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setHiringDate(EmployeeMapper.INSTANCE.convertToLocalDate(employee.getHiringDate()));

        return (T) dbPort.update(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        dbPort.deleteById(id);
    }
}
