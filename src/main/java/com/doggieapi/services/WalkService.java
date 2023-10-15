package com.doggieapi.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.doggieapi.models.Walk;

public interface WalkService {
    Optional<List<Walk>> getAllWalks(Long dogId, Long ownerId, LocalDateTime date);
    Optional<Walk> getWalkById(Long id);
    Walk createWalk(Walk walk);
    Optional<Walk> updateWalk(Long id, Walk walk);
    boolean deleteWalk(Long id);
}
