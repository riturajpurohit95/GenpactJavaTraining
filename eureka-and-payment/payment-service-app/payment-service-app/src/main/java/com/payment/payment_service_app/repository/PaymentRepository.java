package com.payment.payment_service_app.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.support.GeneratedKeyHolder;

import org.springframework.jdbc.support.KeyHolder;

import org.springframework.stereotype.Repository;

import com.payment.payment_service_app.model.Payment;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.List;
 
@Repository
public class PaymentRepository {

  private final JdbcTemplate jdbc;
 
  public PaymentRepository(JdbcTemplate jdbc) {

    this.jdbc = jdbc;

  }
 
  public Payment create(Payment p) {

    final String sql = "INSERT INTO payment(order_id, amount, status, created_at) VALUES (?, ?, ?, ?)";

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbc.update(connection -> {

      PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

      ps.setLong(1, p.getOrderId());

      ps.setDouble(2, p.getAmount());

      ps.setString(3, p.getStatus());

      ps.setTimestamp(4, java.sql.Timestamp.valueOf(p.getCreatedAt()));

      return ps;

    }, keyHolder);

    Number key = keyHolder.getKey();

    if (key != null) p.setId(key.longValue());

    return p;

  }
 
  public List<Payment> findAll() {

    return jdbc.query("SELECT id, order_id, amount, status, created_at FROM payment", new PaymentRowMapper());

  }
 
  static class PaymentRowMapper implements RowMapper<Payment> {

    @Override

    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {

      Payment p = new Payment();

      p.setId(rs.getLong("id"));

      p.setOrderId(rs.getLong("order_id"));

      p.setAmount(rs.getDouble("amount"));

      p.setStatus(rs.getString("status"));

      p.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

      return p;

    }

  }

}
 
 