package com.jyoti.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jyoti.model.Employee;



@Configuration
@EnableWebMvc//this is mvc project
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan("com.jyoti")
public class AppConfig  {
	@Autowired
	Environment env;
	@Bean
  public DataSource createDS() {
	  BasicDataSource ds=new BasicDataSource();
	  ds.setDriverClassName(env.getProperty("jdbc.driverclass"));
      ds.setUrl(env.getProperty("jdbc.url")); 
      ds.setUsername(env.getProperty("jdbc.username"));
      ds.setPassword(env.getProperty("jdbc.password"));
      return ds;
	}
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean sf= new LocalSessionFactoryBean();
		sf.setDataSource(createDS());
		sf.setHibernateProperties(props());
		//sf.setAnnotatedClasses(Employee.class);
		sf.setAnnotatedPackages("com.jyoti.model");
		return sf;
	}
	
	public Properties  props() {
		Properties p =new Properties();
		p.put("hibernate.dialect", env.getProperty("hib.dialect"));
		p.put("hibernate.show_sql", env.getProperty("hib.show"));
		p.put("hibernate.format_sql", env.getProperty("hib.fmt"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("hib.ddl2"));

		return p;
	}
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sf().getObject());
		return ht;
	}
	@Bean
	public HibernateTransactionManager tx() {
		HibernateTransactionManager tx=new HibernateTransactionManager();
		tx.setSessionFactory(sf().getObject());
		return tx;
	}
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver ivr=new InternalResourceViewResolver();
		ivr.setPrefix(env.getProperty("view.perfix"));
		ivr.setSuffix(env.getProperty("view.suffix"));
		return ivr;
	}

}
