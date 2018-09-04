package com.testtask.config;

import java.util.Properties;

import javax.sql.DataSource;

import com.testtask.dao.CategDAO;
import com.testtask.dao.CategDAOImp;

import com.testtask.service.CatService;
import com.testtask.service.ServiceCatImp;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource(value = { "classpath:config.properties" })
@ComponentScan(basePackages = {"com.testtask.service", "com.testtask.dao","com.testtask.config"})
@EnableTransactionManagement
public class SpringConfig {
	
	 @Autowired
	 private Environment environment;

	 
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.testtask.entity" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	        return dataSource;
	    }
	 private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        return properties;        
	    }
	 @Bean
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }

	    @Bean
	public CategDAO getCategDAO(){
	 	return new CategDAOImp();
		}




}
