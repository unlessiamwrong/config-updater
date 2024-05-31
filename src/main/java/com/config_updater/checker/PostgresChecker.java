package com.config_updater.checker;

import com.config_updater.entities.ConfigurationFile;
import com.config_updater.entities.PostgresConfigurationFile;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostgresChecker implements Checker<PostgresConfigurationFile> {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public ConfigurationFile getFile() {
        String properties = jdbcTemplate.queryForObject("select properties from configs", String.class);
        return new PostgresConfigurationFile(properties);
    }

    @Override
    public boolean isPropertiesUpdated(ConfigurationFile currentConfigurationFile, ConfigurationFile newConfigurationFile) {
        String currentProperties = currentConfigurationFile.getProperties();
        String newProperties = newConfigurationFile.getProperties();

        return !currentProperties.equals(newProperties);
    }
}
