package com.kibernumacademy.security.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
  @GetMapping
  public ResponseEntity<Map<String, String>> welcome() {
    return ResponseEntity.ok(Collections.singletonMap("message", "welcome"));
  }
}
