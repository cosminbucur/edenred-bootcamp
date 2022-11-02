package com.sda.spring.jdbctemplate.mapper;

import com.sda.spring.jdbctemplate.dto.EmployeeDTO;
import com.sda.spring.jdbctemplate.model.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDto(Employee employee) {
        Long employeeId = employee.getEmployeeId();
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String email = employee.getEmail();
        String phoneNumber = employee.getPhoneNumber();
        LocalDate hireDate = employee.getHireDate();
        Long jobId = employee.getJobId();
        Double salary = employee.getSalary();
        Long managerId = employee.getManagerId();
        Long departmentId = employee.getDepartmentId();

        return new EmployeeDTO(
                employeeId, firstName,
                lastName, email,
                phoneNumber, hireDate,
                jobId, salary,
                managerId, departmentId
        );
    }
}
