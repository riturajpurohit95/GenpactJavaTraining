package com.example.inventory.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.inventory.dao.InventoryDao;
import com.example.inventory.dao.InventoryDaoImplement;
import com.example.inventory.service.InventoryService;

public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");;
		ds.setUrl("jdbc:mysql://localhost:3306/inventory_db");
		ds.setUsername("root");
		ds.setPassword("Genpact@123456789");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate idbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public InventoryDao inventoryDao(JdbcTemplate jdbcTemplate) {
		return new InventoryDaoImplement(jdbcTemplate);
	}
	
	@Bean
	public InventoryService inventoryService(InventoryDao dao) {
		return new InventoryService(dao);
	}

}
