package com.test.ms.employee.adapters.out.persistence.sql.repository;

import com.test.ms.employee.adapters.out.persistence.sql.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlRepository extends JpaRepository<EmployeeEntity, Long> {
}
