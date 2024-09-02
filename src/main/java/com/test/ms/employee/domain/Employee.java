package com.test.ms.employee.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Employee {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Position is mandatory")
    private String position;

    @NotNull(message = "Salary is mandatory")
    @Min(value = 1, message = "Salary must be greater than 0")
    private BigDecimal salary;

    @NotNull(message = "Hiring Date is mandatory")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Invalid date format. Please use dd-MM-yyyy")
    private String hiringDate;
}
