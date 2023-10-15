package com.doggieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doggieapi.models.Dog;

public interface DogRepository extends JpaRepository<Dog, Long>{
    
}
