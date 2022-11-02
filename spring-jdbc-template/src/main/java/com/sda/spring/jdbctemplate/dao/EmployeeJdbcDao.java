package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Repository
public class EmployeeJdbcDao implements DAO<Employee> {

    private final JdbcTemplate jdbcTemplate;
    // private row mapper
    private final RowMapper<Employee> rowMapper = (resultSet, rowNum) -> {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setPhoneNumber(resultSet.getString("phone_number"));
        employee.setEmail(resultSet.getString("email"));
        return employee;
    };

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees (" +
                "employee_id," +
                "first_name," +
                "last_name," +
                "email," +
                "phone_number," +
                "hire_date," +
                "job_id," +
                "salary," +
                "manager_id," +
                "department_id" +
                ")" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getJobId(),
                employee.getSalary(),
                employee.getManagerId(),
                employee.getDepartmentId()
        );
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";

        // query for a list
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        Employee employee = null;
        try {
            // query with param
            employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (DataAccessException exception) {
            log.info("Employee not found: " + id);
        }
        return Optional.ofNullable(employee);
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM employees";

        // query for an integer
        Integer rowCount = this.jdbcTemplate.queryForObject(sql, Integer.class);
        return rowCount;
    }

    @Override
    public void update(Employee employee, Long id) {
        String sql = "UPDATE employees SET " +
                "employee_id = ?, " +
                "first_name = ?, " +
                "last_name = ?, " +
                "email = ?, " +
                "phone_number = ?, " +
                "hire_date = ?, " +
                "job_id = ?," +
                "salary = ?, " +
                "manager_id = ?, " +
                "department_id = ? " +
                "where employee_id = ?";
        int rowsAffected = jdbcTemplate.update(
                sql,
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getJobId(),
                employee.getSalary(),
                employee.getManagerId(),
                employee.getDepartmentId()
        );

        if (rowsAffected == 1) {
            log.info("Employee updated: " + employee.getLastName());
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employees WHERE employee_id = ?", id);
    }
}
