package com.kibernumacademy.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="customers")
public class CustomEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable=false, unique=true, length = 50)
  private String email;
  @Column(nullable=false,length = 500 )
  private String password;
  @Column(nullable=false, length = 20)
  private String role;
}


/*
 * CREATE TABLE customers (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- ID autoincremental como clave primaria
    email VARCHAR(50) NOT NULL UNIQUE,            -- Campo único para el email
    password VARCHAR(500) NOT NULL,                    -- Contraseña encriptada
    role VARCHAR(20) NOT NULL                      -- Rol o autoridad del usuario
);
 * 
 */