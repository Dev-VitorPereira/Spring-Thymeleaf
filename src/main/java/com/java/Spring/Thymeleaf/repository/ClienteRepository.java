package com.java.Spring.Thymeleaf.repository;

import com.java.Spring.Thymeleaf.model.Cliente;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}

