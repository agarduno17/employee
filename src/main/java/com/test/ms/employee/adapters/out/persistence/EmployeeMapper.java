package com.test.ms.employee.adapters.out.persistence;

import com.test.ms.employee.adapters.out.persistence.sql.entity.EmployeeEntity;
import com.test.ms.employee.domain.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "hiringDate", expression = "java(convertToLocalDate(employee.getHiringDate()))")
    EmployeeEntity toEntity(Employee employee);

    default LocalDate convertToLocalDate(String hiringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(hiringDate, formatter);
    }

}
