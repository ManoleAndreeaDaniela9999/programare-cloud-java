package com.unitbv.profiles.automatically;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:profiles.properties")
@ComponentScan
public class AppConfig {
}
