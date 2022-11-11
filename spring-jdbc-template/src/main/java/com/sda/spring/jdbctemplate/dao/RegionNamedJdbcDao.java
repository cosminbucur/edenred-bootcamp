package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Region;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@AllArgsConstructor
@Repository
public class RegionNamedJdbcDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(Region region) {
        String sql = "INSERT INTO regions (" +
                "region_id," +
                "region_name" +
                ") " +
                "values (:regionId, :regionName)";

        // parameter source as bean
        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(region);
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public Optional<Region> findById(Long id) {
        String sql = "SELECT * FROM regions WHERE region_id = :regionId";
        Region region = null;
        try {
            // parameter source as map with single entry
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            namedParameters.addValue("regionId", id);
            region = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, rowMapper);
        } catch (DataAccessException exception) {
            log.info("Region not found: " + id);
        }
        return Optional.ofNullable(region);
    }

    // private row mapper
    private final RowMapper<Region> rowMapper = (resultSet, rowNum) -> {
        Region region = new Region();
        region.setRegionId(resultSet.getLong("region_id"));
        region.setRegionName(resultSet.getString("region_name"));
        return region;
    };

    public void update(Region region, Long id) {
        String sql = "UPDATE regions SET " +
                "region_name = :regionName " +
                "WHERE region_id = :regionId";

        // parameter source as map
        MapSqlParameterSource namedParameters = new MapSqlParameterSource(Map.of(
                "regionName", region.getRegionName(),
                "regionId", id
        ));
        int rowsAffected = namedParameterJdbcTemplate.update(sql, namedParameters);

        if (rowsAffected == 1) {
            log.info("Region updated: " + region.getRegionName());
        }
    }

    public Optional<Region> findByName(String regionName) {
        String sql = "SELECT * FROM regions WHERE region_name LIKE :regionName";
        Region region = null;
        try {
            // parameter source as map with single entry
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            namedParameters.addValue("regionName", "%" + regionName + "%");
            region = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, rowMapper);
        } catch (DataAccessException exception) {
            log.info("Region not found: " + regionName);
        }
        return Optional.ofNullable(region);
    }
}
