package com.example.inventory.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.example.inventory.model.Item;

public class InventoryDaoImplement implements InventoryDao{
	
	//actual code for all CRUD methods
	
	//jdbcTemplate - injected by spring and db operations
	//manage - open connection, creating statements, executing queries, mapping results,
	//closing resources
	
	private final JdbcTemplate jdbcTemplate;
	
	//injected using a constructor injection
	//spring pass a configured JdbcTemplate bean
	public InventoryDaoImplement(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//helper method
	//maoRow - convert a single row of resultSet (sql result) into a java Item object
	//this is called row mapping
	
	private Item mapRow(ResultSet rs, int rowNum) throws SQLException{
		Item i = new Item();
		i.setId(rs.getLong("id"));
		i.setName(rs.getString("name"));
		i.setDescription(rs.getString("description"));
		i.setUnitPrice(rs.getBigDecimal("unit_price"));
		i.setQuantity(rs.getInt("quantity"));
		Timestamp created = rs.getTimestamp("created_at");
		if (created != null) i.setCreatedAt(created.toLocalDateTime());
		Timestamp updated = rs.getTimestamp("updated_at");
		if (updated != null) i.setUpdatedAt(updated.toLocalDateTime());
		
		return i;
	}
	
	//all CRUD implementations

	@Override
	public Long create(Item item) {
		
		String sql = "insert into items (name, description, unit_price, quantity) values (?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder(); //capture the auto generated key
		
		jdbcTemplate.update(con -> {
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, item.getName());
			ps.setString(2, item.getDescription());
			ps.setBigDecimal(3, item.getUnitPrice());
			ps.setInt(4, item.getQuantity());
		
			return ps;
		}, keyHolder);
		
		Number key = keyHolder.getKey();
		return key!=null ? key.longValue() : null;
		
	}

	@Override
	public Optional<Item> findById(Long id) {
		try {
			String sql = "select * from items where id=?";
			
			Item item = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapRow(rs, rowNum),id);
			return Optional.ofNullable(item);
		}catch(EmptyResultDataAccessException e){
			return Optional.empty();
		}
	}

	@Override
	public List<Item> findAll(int offset, int limit) {
			String sql = "select * from items order by id limit ? offset ?";
			
			return jdbcTemplate.query(sql, (rs, rowNum)-> mapRow(rs, rowNum), limit, offset);
			
	}

	@Override
	public int update(Item item) {
		String sql = "UPDATE items SET name = ?, description = ?,unit_price = ?, quantity = ? WHERE id = ?";
		
		return jdbcTemplate.update(sql,
				item.getName(),
				item.getDescription(),
				item.getUnitPrice(),
				item.getQuantity(),
				item.getId());
	}

	@Override
	public int delete(Long id) {
		String sql = "delete from items where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public boolean reduceQuantity(Long id, int quantityToReduce) {
		
		String sql  = "update items set quantity = quantity - ? where id = ? and quantity >= ?";
		
		int rows = jdbcTemplate.update(sql, quantityToReduce, id, quantityToReduce);
		return rows>0;
	}

}
