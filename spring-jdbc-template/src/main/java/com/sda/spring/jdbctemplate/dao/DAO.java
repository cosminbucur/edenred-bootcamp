package com.sda.spring.jdbctemplate.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    void save(T t);

    List<T> findAll();

    Optional<T> findById(Long id);

    void update(T t, Long id);

    void delete(Long id);
}

