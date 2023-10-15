package com.doggieapi.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import lombok.Data;

@Entity
@Data
public class Walk {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private LocalDateTime dateTime;

    
    private Long dogId;

    private Long ownerId;
    
}
