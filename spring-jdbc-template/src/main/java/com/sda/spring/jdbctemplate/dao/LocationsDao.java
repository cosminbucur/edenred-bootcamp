package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Locations;

import java.util.List;
import java.util.Optional;

public class LocationsDao implements DAO<Locations> {
    @Override
    public Optional<Locations> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Locations> findAll() {
        return null;
    }

    @Override
    public void save(Locations locations) {

    }

    @Override
    public void update(Locations locations, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
