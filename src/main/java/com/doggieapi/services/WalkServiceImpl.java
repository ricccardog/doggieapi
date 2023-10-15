package com.doggieapi.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggieapi.models.Dog;
import com.doggieapi.models.Owner;
import com.doggieapi.models.Walk;
import com.doggieapi.repositories.DogRepository;
import com.doggieapi.repositories.OwnerRepository;
import com.doggieapi.repositories.WalkRepository;

import org.springframework.data.domain.Sort;

import jakarta.persistence.criteria.Predicate;

@Service
public class WalkServiceImpl implements WalkService {

    @Autowired
    private WalkRepository walkRepository;

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Optional<List<Walk>> getAllWalks(Long dogId, Long ownerId, LocalDateTime date) {
        List<Walk> walks = walkRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dogId != null) {
                predicates.add(criteriaBuilder.equal(root.get("dog").get("id"), dogId));
            }

            if (dogId != null) {
                predicates.add(criteriaBuilder.equal(root.get("ownerId"), ownerId));
            }

            if (date != null) {
                predicates.add(criteriaBuilder.equal(root.get("datetime"), date));
            }

            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        }, Sort.by(Sort.Order.desc("dateTime")));

        return Optional.ofNullable(walks);
    }

    @Override
    public Optional<Walk> getWalkById(Long id) {
        return walkRepository.findById(id);
    }

    @Override
    public Walk createWalk(Walk walk) {
        if (walk.getDogId() != null) {
            Optional<Dog> dog = dogRepository.findById(walk.getDogId());
            dog.ifPresent(value -> walk.setOwnerId(value.getOwner().getId()));
        }
        if (walk.getOwnerId() != null) {
            Optional<Owner> owner = ownerRepository.findById(walk.getOwnerId());
            owner.ifPresent(value -> walk.setDogId(value.getDog().getId()));
        }

        return walkRepository.save(walk);
    }

    @Override
    public Optional<Walk> updateWalk(Long id, Walk walk) {
        Optional<Walk> currentWalk = walkRepository.findById(id);

        if (currentWalk.isPresent()) {
            Walk toUpdate = currentWalk.get();

            if (walk.getLocation() != null) {
                toUpdate.setLocation(walk.getLocation());
            }
            if (walk.getDateTime() != null) {
                toUpdate.setDateTime(walk.getDateTime());
            }

            return Optional.of(walkRepository.save(toUpdate));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteWalk(Long id) {
        if (walkRepository.existsById(id)) {
            walkRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
