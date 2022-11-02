package com.sda.spring.jdbctemplate.config;

import com.sda.spring.jdbctemplate.dao.EmployeeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DbInit {

    @Autowired
    EmployeeDao employeeDao;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {

        };
    }
}
