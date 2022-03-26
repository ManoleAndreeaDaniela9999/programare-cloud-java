package com.unitbv.profiles.programatically;


public class ProdDataSourceConfig implements DataSourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for PROD environment. ");
    }
}
