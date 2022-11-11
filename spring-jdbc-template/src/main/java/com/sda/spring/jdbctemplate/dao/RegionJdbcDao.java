package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Region;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Repository
public class RegionJdbcDao implements DAO<Region> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Region region) {
        String sql = "INSERT INTO regions (" +
                "region_id," +
                "region_name" +
                ") " +
                "values (?, ?)";

        jdbcTemplate.update(
                sql,
                region.getRegionId(),
                region.getRegionName()
        );
    }

    // private row mapper
    private final RowMapper<Region> rowMapper = (resultSet, rowNum) -> {
        Region region = new Region();
        region.setRegionId(resultSet.getLong("region_id"));
        region.setRegionName(resultSet.getString("region_name"));
        return region;
    };

    @Override
    public List<Region> findAll() {
        String sql = "SELECT * FROM regions";

        // query for a list
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Region> findById(Long id) {
        String sql = "SELECT * FROM regions WHERE region_id = ?";
        Region region = null;
        try {
            // query with param
            region = jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (DataAccessException exception) {
            log.info("Region not found: " + id);
        }
        return Optional.ofNullable(region);
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM regions";

        // query for an integer
        Integer rowCount = this.jdbcTemplate.queryForObject(sql, Integer.class);
        return rowCount;
    }

    @Override
    public void update(Region region, Long id) {
        String sql = "UPDATE regions SET " +
                "region_name = ? " +
                "WHERE region_id = ?";
        int rowsAffected = jdbcTemplate.update(
                sql,
                region.getRegionName(),
                region.getRegionId()
        );

        if (rowsAffected == 1) {
            log.info("Region updated: " + region.getRegionName());
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM regions WHERE region_id = ?";

        jdbcTemplate.update(sql, id);
    }

    public Region advancedSave(Region region) {
        String sql = "INSERT INTO regions (" +
                "region_name" +
                ") " +
                "values (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"region_id"});
            ps.setString(1, region.getRegionName());
            return ps;
        }, keyHolder);
        Number generatedKey = keyHolder.getKey();
        region.setRegionId(generatedKey.longValue());
        return region;
    }

    public int[] batchUpdate(final List<Region> regions) {
        String sql = "UPDATE regions SET region_name = ? WHERE region_id = ?";

        BatchPreparedStatementSetter batchPreparedStatementSetter = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Region region = regions.get(i);
                ps.setString(1, region.getRegionName());
                ps.setLong(2, region.getRegionId());
            }

            public int getBatchSize() {
                return regions.size();
            }
        };

        return this.jdbcTemplate.batchUpdate(sql, batchPreparedStatementSetter);
    }
}
