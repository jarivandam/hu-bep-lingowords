package com.jarivandam.lingowords;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@EnableAutoConfiguration
public class AppConfig {
    public  static  final String DEFAULT_DB_URL= "postgres://dev:dev@localhost:54321/lingowords";

    @Bean
    public DataSource getDataSource() throws URISyntaxException {
        String dbUrl = System.getenv("DATABASE_URL");
        if (dbUrl == null){
            dbUrl = DEFAULT_DB_URL;
        }

        URI dbURI = new URI(dbUrl);

        String username = dbURI.getUserInfo().split(":")[0];
        String password = dbURI.getUserInfo().split(":")[1];
        String jdbcUrl = "jdbc:postgresql://" + dbURI.getHost() + ":" + dbURI.getPort() + dbURI.getPath();

        return DataSourceBuilder.create().url(jdbcUrl).username(username).password(password).build();
    }
}
