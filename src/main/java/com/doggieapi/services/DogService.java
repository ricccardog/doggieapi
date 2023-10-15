package com.doggieapi.services;

import java.util.List;
import java.util.Optional;

import com.doggieapi.models.Dog;

public interface DogService {
    Optional<List<Dog>> getAllDogs();
    Optional<Dog> getDogById(Long id);
    Dog createDog(Dog dog);
    Optional<Dog> updateDog(Long id, Dog dog);
    boolean deleteDog(Long id);
}
