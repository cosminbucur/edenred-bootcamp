package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Departments;

import java.util.List;
import java.util.Optional;

public class DepartmentsDao implements DAO<Departments> {
    @Override
    public Optional<Departments> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Departments> findAll() {
        return null;
    }

    @Override
    public void save(Departments dependents) {

    }

    @Override
    public void update(Departments dependents, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
