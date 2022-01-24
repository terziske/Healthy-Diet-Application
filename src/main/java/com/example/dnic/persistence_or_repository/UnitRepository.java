package com.example.dnic.persistence_or_repository;

import com.example.dnic.model.Unit;

import java.util.List;
import java.util.Optional;

public interface UnitRepository {
    List<Unit> findAll();
    Optional<Unit> findById(Long id);
}
