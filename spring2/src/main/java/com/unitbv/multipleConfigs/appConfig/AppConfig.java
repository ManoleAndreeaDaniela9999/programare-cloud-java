package com.unitbv.multipleConfigs.appConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.unitbv.multipleConfigs.appConfig")
//@Import()
public class AppConfig {

}
