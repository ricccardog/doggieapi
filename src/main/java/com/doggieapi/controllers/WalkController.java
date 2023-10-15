package com.doggieapi.controllers;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doggieapi.models.Walk;
import com.doggieapi.services.WalkService;

@RestController
@RequestMapping("/walks")
public class WalkController {

    @Autowired
    private WalkService walkService;

    @GetMapping
    public ResponseEntity<List<Walk>> getAllWalks(
            @RequestParam(required = false) Long dogId,
            @RequestParam(required = false) Long ownerId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        List<Walk> walks = walkService.getAllWalks(dogId, ownerId, date).orElse(Collections.emptyList());
        return new ResponseEntity<>(walks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Walk> getWalkById(@PathVariable Long id) {
        Optional<Walk> walk = walkService.getWalkById(id);

        if (walk.isPresent()) {
            return new ResponseEntity<>(walk.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Walk> createWalk(@RequestBody Walk walk) {
        Walk createdWalk = walkService.createWalk(walk);
        return new ResponseEntity<>(createdWalk, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Walk> updateWalk(@PathVariable Long id, @RequestBody Walk walk) {
        Optional<Walk> updated = walkService.updateWalk(id, walk);
        if (updated.isPresent()) {
            return new ResponseEntity<>(updated.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWalk(@PathVariable Long id) {
        boolean deleted = walkService.deleteWalk(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
