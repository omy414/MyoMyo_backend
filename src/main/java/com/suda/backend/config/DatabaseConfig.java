package com.suda.backend.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;



@Configuration
@MapperScan(basePackages = "com.suda.backend.repository")
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.hikari.master")
    public DataSource dataSourceMaster() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @DependsOn({ "dataSourceMaster" })
    @Bean
    public DataSource routingDataSource(@Qualifier("dataSourceMaster") DataSource dataSourceMaster) {

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("master", dataSourceMaster);

        PostgreSQLRoutingDataSource routingDataSource = new PostgreSQLRoutingDataSource();
        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(dataSourceMaster);
        return routingDataSource;
    }

    @Primary
    @DependsOn({ "routingDataSource" })
    @Bean
    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/postgre-*.xml"));
        Resource myBatisConfig = new PathMatchingResourcePatternResolver()
                .getResource("classpath:mybatis/mybatis-config.xml");
        sessionFactory.setConfigLocation(myBatisConfig);

        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
