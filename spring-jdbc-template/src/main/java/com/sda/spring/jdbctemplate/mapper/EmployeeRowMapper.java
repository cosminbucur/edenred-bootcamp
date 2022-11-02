package com.sda.spring.jdbctemplate.mapper;

import com.sda.spring.jdbctemplate.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setPhoneNumber(rs.getString("phone_number"));
        employee.setEmail(rs.getString("email"));
        return employee;
    }
}
