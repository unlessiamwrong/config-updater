package com.config_updater;

import com.config_updater.checker.PostgresChecker;
import com.config_updater.configuration.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
@EnableScheduling
@RequiredArgsConstructor
public class Application {

    private final JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        PostgresChecker postgresChecker = new PostgresChecker(jdbcTemplate);
        System.out.println(postgresChecker.getFile().getProperties());
    }
}
