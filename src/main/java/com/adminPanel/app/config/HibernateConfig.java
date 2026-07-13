package com.adminPanel.app.config;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.adminPanel.app")
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(System.getenv("hibernate.connection.driver_class"));
        dataSource.setJdbcUrl(System.getenv("hibernate.connection.url"));
        dataSource.setUsername(System.getenv("hibernate.connection.username"));
        dataSource.setPassword(System.getenv("hibernate.connection.password"));
        return dataSource ;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean() ;
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.adminPanel.app");

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect",System.getenv("hibernate.dialect"));

        hibernateProperties.put("hibernate.show_sql",System.getenv("hibernate.show_sql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto",System.getenv("hibernate.hbm2ddl.auto"));
        hibernateProperties.put("hibernate.current_session_context_class",System.getenv("hibernate.current_session_context_class"));

        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager() ;
        hibernateTransactionManager.setSessionFactory(sessionFactory);

        return hibernateTransactionManager;
    }
}
