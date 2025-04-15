package com.java.Spring.Thymeleaf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "cliente")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    Long id;

    private String nome;
    private int idade;
    private String email;

}
