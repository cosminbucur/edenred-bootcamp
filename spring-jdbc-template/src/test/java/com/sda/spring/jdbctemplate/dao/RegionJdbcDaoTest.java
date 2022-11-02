package com.sda.spring.jdbctemplate.dao;

import com.sda.spring.jdbctemplate.model.Region;
import com.sda.spring.jdbctemplate.model.Region;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RegionJdbcDaoTest {

    @Autowired
    private RegionJdbcDao dao;

    @BeforeEach
    void setUp() {
//        dao.findAll()
//                .forEach(item -> dao.delete(item.getRegionId()));
    }

    @Test
    void save() {
        Region region = new Region();
        region.setRegionId(1L);
        region.setRegionName("Region");

        dao.save(region);

        assertThat(dao.count()).isEqualTo(1);
    }

    @Test
    void smartSave() {
        Region region = new Region();
        region.setRegionName("Region");

        dao.smartSave(region);

        assertThat(dao.count()).isEqualTo(1);
    }

    @Test
    void findAll() {
        Region region = new Region();
        region.setRegionId(1L);
        region.setRegionName("Region");
        dao.save(region);

        List<Region> actual = dao.findAll();

        assertThat(actual).isNotEmpty();
    }

    @Test
    void findById() {
        Region region = new Region();
        region.setRegionId(1L);
        region.setRegionName("Region");
        dao.save(region);

        Optional<Region> actual = dao.findById(1L);

        assertThat(actual.get()).isNotNull();
    }

    @Test
    void count() {
        Region region = new Region();
        region.setRegionId(1L);
        region.setRegionName("Region");
        dao.save(region);

        int count = dao.count();

        assertThat(count).isEqualTo(1);
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

    @Test
    void delete() {
        Region region = new Region();
        region.setRegionId(1L);
        region.setRegionName("Region");
        dao.save(region);

        dao.delete(1L);

        int count = dao.count();
        assertThat(count).isEqualTo(0);
    }
}