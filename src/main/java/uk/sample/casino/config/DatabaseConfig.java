package uk.sample.casino.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Database configuration
 */
@Configuration
@EnableJpaRepositories(value = {"uk.sample.casino.repository"})
@EntityScan(basePackages = {"uk.sample.casino.model"})
@EnableTransactionManagement
public class DatabaseConfig {

}
