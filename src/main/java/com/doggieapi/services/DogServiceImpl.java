package com.doggieapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggieapi.models.Dog;
import com.doggieapi.repositories.DogRepository;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Override
    public Optional<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogRepository.findAll();
        return Optional.ofNullable(dogs);
    }

    @Override
    public Optional<Dog> getDogById(Long id) {
        return dogRepository.findById(id);
    }

    @Override
    public Dog createDog(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public Optional<Dog> updateDog(Long id, Dog dog) {
        Optional<Dog> currentDog = dogRepository.findById(id);

        if (currentDog.isPresent()) {
            Dog dogToUpdate = currentDog.get();
            dogToUpdate.setName(dog.getName());
            dogToUpdate.setRace(dog.getRace());
            dogToUpdate.setColor(dog.getColor());
            dogToUpdate.setAge(dog.getAge());

            if(dog.getOwner() != null) {
                dogToUpdate.setOwner(dog.getOwner());
            }
            dogRepository.save(dogToUpdate);

            return Optional.of(dogToUpdate);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteDog(Long id) {
        if(dogRepository.existsById(id)){
        dogRepository.deleteById(id);
            return true;
    } else {
        return false;
    }
    }
}
