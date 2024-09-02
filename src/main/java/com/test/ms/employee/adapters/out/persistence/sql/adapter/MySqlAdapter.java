package com.test.ms.employee.adapters.out.persistence.sql.adapter;

import com.test.ms.employee.adapters.out.persistence.EmployeeMapper;
import com.test.ms.employee.adapters.out.persistence.sql.entity.EmployeeEntity;
import com.test.ms.employee.adapters.out.persistence.sql.repository.MySqlRepository;
import com.test.ms.employee.application.port.out.DbPort;
import com.test.ms.employee.domain.Employee;
import com.test.ms.employee.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MySqlAdapter implements DbPort<EmployeeEntity> {

    private final MySqlRepository mySqlRepository;
    @Override
    public EmployeeEntity save(Employee domainEmployee) {
        var employee = EmployeeMapper.INSTANCE.toEntity(domainEmployee);
        return mySqlRepository.save(employee);
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return mySqlRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return mySqlRepository.findAll();

    }

    @Override
    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        return mySqlRepository.save(employeeEntity);
    }

    @Override
    public void deleteById(Long id) {
        if (mySqlRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Employee not found with id " + id);
        }
        mySqlRepository.deleteById(id);
    }
}
