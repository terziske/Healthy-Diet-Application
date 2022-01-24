package com.example.dnic.persistence_or_repository.impl;

import com.example.dnic.model.Product;
import com.example.dnic.model.Unit;
import com.example.dnic.persistence_or_repository.UnitRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class UnitRepositoryImpl implements UnitRepository {
    private HashMap<Long, Unit> units;

    public UnitRepositoryImpl() {
        this.units = new HashMap<>();
        Unit u1 = new Unit(1L, "g");
        Unit u2 = new Unit(2L, "Cal");
        this.units.put(u1.getId(), u1);
        this.units.put(u2.getId(), u2);
    }

    @Override
    public List<Unit> findAll() {
        return new ArrayList<>(this.units.values());
    }

    @Override
    public Optional<Unit> findById(Long id) {
        return Optional.of(this.units.get(id));
    }
}
