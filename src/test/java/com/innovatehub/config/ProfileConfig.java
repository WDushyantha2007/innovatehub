package com.innovatehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@Configuration
@Import(InnovateHubConfig.class)
public class ProfileConfig {

    @Bean
    public DataSource dataSource(){
        return
                (new EmbeddedDatabaseBuilder())
                        .build();
    }

}
