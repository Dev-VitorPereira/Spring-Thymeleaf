package com.java.Spring.Thymeleaf.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Long, Id>{

}
