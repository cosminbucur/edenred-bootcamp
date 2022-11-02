package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Region;

import java.util.List;
import java.util.Optional;

public class RegionsDao implements DAO<Region> {
    @Override
    public Optional<Region> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Region> findAll() {
        return null;
    }

    @Override
    public void save(Region region) {

    }

    @Override
    public void update(Region region, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
