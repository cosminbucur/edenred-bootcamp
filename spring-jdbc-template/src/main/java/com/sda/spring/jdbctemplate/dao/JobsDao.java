package com.sda.spring.jdbctemplate.dao;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.sda.spring.jdbctemplate.exceptions.CustomSQLErrorCodeTranslator;
import com.sda.spring.jdbctemplate.model.Jobs;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class JobsDao implements DAO<Jobs> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Jobs> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Jobs> findAll() {
        return null;
    }

    @Override
    public void save(Jobs jobs) {

    }

    @Override
    public void update(Jobs jobs, Long id) {

    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.setExceptionTranslator(new CustomSQLErrorCodeTranslator());
        String sql = "delete jobs where job_id = ?";
        Object[] params = {id};
        try {
            int rows = jdbcTemplate.update(sql, params);
            System.out.println("Rows deleted: " + rows);
        } catch (DataAccessException exception) {
            exception.printStackTrace();
        }
    }
}
