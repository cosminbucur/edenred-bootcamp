package com.sda.spring.jdbctemplate.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.sda.spring.jdbctemplate.mapper.EmployeeRowMapper;
import com.sda.spring.jdbctemplate.model.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeDao implements DAO<Employee> {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> employeeRowMapper = (resultSet, rowNum) -> {
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
                "department_id)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
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
    public Optional<Employee> findById(Long id) {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        Employee employee = null;
        try {
            employee = jdbcTemplate.queryForObject(sql, employeeRowMapper, new MapSqlParameterSource().addValue("id", id));
        } catch (DataAccessException exception) {
            log.info("Employee not found: " + id);
        }
        return Optional.ofNullable(employee);
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employees";
        return namedParameterJdbcTemplate
                .query(sql, new EmployeeRowMapper());
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
        int update = jdbcTemplate.update(sql,
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

        if (update == 1) {
            log.info("Employee updated: " + employee.getLastName());
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE employee_id = ?", id);
    }

    public int[] batchUpdate(List<Employee> employees) {
        return this.jdbcTemplate.batchUpdate(
                "UPDATE employees SET first_name = ?, last_name = ? where employee_id = ?",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Employee employee = employees.get(i);
                        ps.setString(1, employee.getFirstName());
                        ps.setString(2, employee.getLastName());
                        ps.setLong(3, employee.getEmployeeId().longValue());
                    }

                    public int getBatchSize() {
                        return employees.size();
                    }
                });
    }

    public int[][] batchUpdateBreak(final Collection<Employee> actors) {
        return jdbcTemplate.batchUpdate(
                "update employees set first_name = ?, last_name = ? where employee_id = ?",
                actors,
                100,
                (PreparedStatement ps, Employee employee) -> {
                    ps.setString(1, employee.getFirstName());
                    ps.setString(2, employee.getLastName());
                    ps.setLong(3, employee.getEmployeeId().longValue());
                });
    }
}
