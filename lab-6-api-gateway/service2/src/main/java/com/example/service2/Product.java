package com.example.service2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,updatable = false)
    private Long id;

    @NotNull
    @Column(name = "name",nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "quantity",nullable = false, unique = true)
    private int quantity;
}
