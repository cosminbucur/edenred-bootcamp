package com.fm.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController homeController;

    @Test
    void getInfo() {
        String actual = homeController.checkState();

        assertThat(actual).isNotEmpty();
    }
}