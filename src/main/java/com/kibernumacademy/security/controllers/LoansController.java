package com.kibernumacademy.security.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoansController {
  @GetMapping
  public ResponseEntity<Map<String, String>> loans() {
    return ResponseEntity.ok(Collections.singletonMap("message", "loans"));
  }
}
