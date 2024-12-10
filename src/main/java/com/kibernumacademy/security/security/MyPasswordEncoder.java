package com.kibernumacademy.security.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder{

  private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  @Override
  public String encode(CharSequence charSequence) {
    // Usa BCrypt para encriptar la contraseña
    return bCryptPasswordEncoder.encode(charSequence);
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    // Compara la contraseña sin encriptar con la encriptada
    return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
  }
  
}


  /*@Bean
  PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }*/