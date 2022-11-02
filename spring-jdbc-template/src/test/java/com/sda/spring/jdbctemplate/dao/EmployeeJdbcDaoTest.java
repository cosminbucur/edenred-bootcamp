package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeJdbcDaoTest {

    @Autowired
    private EmployeeJdbcDao dao;

    @Test
    void save() {

    }

    @Test
    void findAll() {
        List<Employee> actual = dao.findAll();

        assertThat(actual).isNotEmpty();
    }

    @Test
    void findById() {
        Optional<Employee> actual = dao.findById(100L);

        assertThat(actual.get()).isNotNull();
    }

    @Test
    void count() {
        int count = dao.count();

        assertThat(count).isEqualTo(40);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        dao.delete(100L);

        int count = dao.count();
        assertThat(count).isEqualTo(39);
    }
}