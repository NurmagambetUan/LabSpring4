package kz.iitu.com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "kz.iitu.com")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "kz.iitu.com.repo")
public class Config {
}
