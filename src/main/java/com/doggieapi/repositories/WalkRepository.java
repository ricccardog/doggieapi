package com.doggieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.doggieapi.models.Walk;

public interface WalkRepository extends JpaRepository<Walk, Long>, JpaSpecificationExecutor<Walk>{
    
}
