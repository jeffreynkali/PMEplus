package com.pme.plus.pmeplus.Config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by gnkali on 7/29/17.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.pme.plus.pmeplus.Entity"})
@EnableJpaRepositories(basePackages = {"com.pme.plus.pmeplus.RepositoryPattern.Repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
