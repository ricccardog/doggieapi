package com.doggieapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Dog dog;
    
}
