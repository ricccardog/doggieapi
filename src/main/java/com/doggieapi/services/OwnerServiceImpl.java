package com.doggieapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggieapi.models.Owner;
import com.doggieapi.repositories.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Optional<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return Optional.ofNullable(owners);
    }

    @Override
    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> updateOwner(Long id, Owner owner) {
        Optional<Owner> currentOwner = ownerRepository.findById(id);

        if (currentOwner.isPresent()) {
            Owner ownerToUpdate = currentOwner.get();
            ownerToUpdate.setName(owner.getName());

            if (owner.getDog() != null) {
                ownerToUpdate.setDog(owner.getDog());
            }
            ownerRepository.save(ownerToUpdate);

            return Optional.of(ownerToUpdate);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteOwner(Long id) {
        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
