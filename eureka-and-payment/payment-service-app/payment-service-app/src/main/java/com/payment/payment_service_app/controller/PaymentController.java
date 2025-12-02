package com.payment.payment_service_app.controller;
 
 
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.payment.payment_service_app.model.Payment;
import com.payment.payment_service_app.repository.PaymentRepository;

import java.time.LocalDateTime;

import java.util.List;
 
@RestController

@RequestMapping("/api/v1/payments")

public class PaymentController {
 
  private final PaymentRepository repo;
 
  public PaymentController(PaymentRepository repo) { this.repo = repo; }
 
  @PostMapping

  public ResponseEntity<Payment> create(@RequestBody Payment p) {

    if (p.getCreatedAt() == null) p.setCreatedAt(LocalDateTime.now());

    if (p.getStatus() == null) p.setStatus("COMPLETED");

    Payment created = repo.create(p);

    return ResponseEntity.ok(created);

  }
 
  @GetMapping

  public List<Payment> all() {

    return repo.findAll();

  }

}

 