package com.unitbv.profiles.stereotype;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class DevDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for DEV environment. ");
    }
}
