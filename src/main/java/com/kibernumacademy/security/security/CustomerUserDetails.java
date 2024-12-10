package com.kibernumacademy.security.security;

// Importaciones necesarias para la clase

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kibernumacademy.security.repository.ICustomerRepository;

import java.util.List;

// Anotación para marcar esta clase como un servicio de Spring
@Service
// Anotación para manejar transacciones
@Transactional
// Anotación de Lombok para generar un constructor con todos los argumentos
@AllArgsConstructor
public class CustomerUserDetails implements UserDetailsService {
  // Repositorio para acceder a los datos de los clientes
  private final ICustomerRepository customerRepository;

  // Método que carga los detalles del usuario por nombre de usuario
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Busca el cliente por email en el repositorio
    return customerRepository.findByEmail(username)
            // Si el cliente es encontrado, mapea los datos del cliente a un objeto User de Spring Security
            .map(customer -> {
              // Crea una lista de autoridades (roles) del usuario
              var authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));
              // Retorna un nuevo objeto User con el email, contraseña y autoridades del cliente
              return new User(customer.getEmail(), customer.getPassword(), authorities);
            })
            // Si el cliente no es encontrado, lanza una excepción UsernameNotFoundException
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}