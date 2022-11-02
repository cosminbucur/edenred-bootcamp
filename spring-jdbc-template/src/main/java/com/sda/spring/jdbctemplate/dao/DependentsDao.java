package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Dependents;

import java.util.List;
import java.util.Optional;

public class DependentsDao implements DAO<Dependents> {
    @Override
    public Optional<Dependents> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Dependents> findAll() {
        return null;
    }

    @Override
    public void save(Dependents dependents) {

    }

    @Override
    public void update(Dependents dependents, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
