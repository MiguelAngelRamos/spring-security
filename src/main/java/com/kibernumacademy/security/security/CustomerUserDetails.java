package com.kibernumacademy.security.security;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kibernumacademy.security.repository.ICustomerRepository;

public class CustomerUserDetails implements UserDetailsService{
  private final ICustomerRepository customerRepository;

  public CustomerUserDetails(ICustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return customerRepository.findByEmail(username).map( customer-> {
      // var authorities = List.of()
    });
  }
  
}
