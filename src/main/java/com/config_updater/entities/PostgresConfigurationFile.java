package com.config_updater.entities;


public record PostgresConfigurationFile(String properties) implements ConfigurationFile {

    @Override
    public String getProperties() {
        return properties;
    }
}
