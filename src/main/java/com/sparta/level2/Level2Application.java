package com.sparta.level2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing // JPA Auditing 활성화하기 위한 어노테이션
@SpringBootApplication
public class Level2Application {

    public static void main(String[] args) {
        SpringApplication.run(Level2Application.class, args);
    }

}
