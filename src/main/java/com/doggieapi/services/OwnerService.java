package com.doggieapi.services;

import java.util.List;
import java.util.Optional;

import com.doggieapi.models.Owner;

public interface OwnerService {
    Optional<List<Owner>> getAllOwners();
    Optional<Owner> getOwnerById(Long id);
    Owner createOwner(Owner Owner);
    Optional<Owner> updateOwner(Long id, Owner Owner);
    boolean deleteOwner(Long id);
}
