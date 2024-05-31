package com.config_updater.checker;

import com.config_updater.entities.ConfigurationFile;

public interface Checker<T> {

    ConfigurationFile getFile();

    boolean isPropertiesUpdated(ConfigurationFile currentConfigurationFile, ConfigurationFile newConfigurationFile);
}
