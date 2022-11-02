package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RegionNamedJdbcDaoTest {

    @Autowired
    private RegionNamedJdbcDao dao;

    @Test
    void save() {
        Region region = new Region();
        region.setRegionId(5L);
        region.setRegionName("Region");

        dao.save(region);

        assertThat(1).isEqualTo(1);
    }

    @Test
    void findById() {
        Region region = new Region();
        region.setRegionId(5L);
        region.setRegionName("Region");
        dao.save(region);

        Optional<Region> actual = dao.findById(5L);

        assertThat(actual.get()).isNotNull();
    }

    @Test
    void findByName() {
        Region region = new Region();
        region.setRegionId(5L);
        region.setRegionName("Region");
        dao.save(region);

        Optional<Region> actual = dao.findByName("Region");

        assertThat(actual.get()).isNotNull();
    }

    @Test
    void update() {
        Region region = new Region();
        region.setRegionId(5L);
        region.setRegionName("Region");
        dao.save(region);

        Region updateRegion = new Region();
        updateRegion.setRegionId(5L);
        updateRegion.setRegionName("Update");

        // when
        dao.update(updateRegion, 5L);

        Optional<Region> updatedRegion = dao.findById(5L);
        assertThat(updatedRegion.get().getRegionName()).isEqualTo("Update");
    }
}