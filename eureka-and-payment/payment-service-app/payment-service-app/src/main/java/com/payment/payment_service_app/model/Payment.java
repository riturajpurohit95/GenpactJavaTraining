package com.payment.payment_service_app.model;
 
import java.time.LocalDateTime;
 
public class Payment {
  private Long id;
  private Long orderId;
  private Double amount;
  private String status;
  private LocalDateTime createdAt;
 
  // constructors
  public Payment() {}
  public Payment(Long orderId, Double amount, String status) {
    this.orderId = orderId;
    this.amount = amount;
    this.status = status;
    this.createdAt = LocalDateTime.now();
  }
 
  // getters/setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Long getOrderId() { return orderId; }
  public void setOrderId(Long orderId) { this.orderId = orderId; }
  public Double getAmount() { return amount; }
  public void setAmount(Double amount) { this.amount = amount; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public LocalDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
 
 
 