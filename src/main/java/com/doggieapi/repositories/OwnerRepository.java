package com.doggieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doggieapi.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long>{
    
}
