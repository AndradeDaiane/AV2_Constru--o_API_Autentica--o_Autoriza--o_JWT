package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 🔍 Busca um usuário pelo nome de login (username).
     * Usado para autenticação e autorização com JWT.
     */
    Optional<User> findByUsername(String username);
}
