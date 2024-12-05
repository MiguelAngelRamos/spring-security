package com.kibernumacademy.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kibernumacademy.security.entity.CustomEntity;

public interface ICustomerRepository extends JpaRepository<CustomEntity, Long> {
  Optional<CustomEntity> findByEmail(String email);
}
