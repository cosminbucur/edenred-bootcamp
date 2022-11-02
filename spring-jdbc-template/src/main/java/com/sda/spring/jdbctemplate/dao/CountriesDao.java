package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Countries;

import java.util.List;
import java.util.Optional;

public class CountriesDao implements DAO<Countries> {

    @Override
    public Optional<Countries> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Countries> findAll() {
        return null;
    }

    @Override
    public void save(Countries dependents) {

    }

    @Override
    public void update(Countries dependents, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
