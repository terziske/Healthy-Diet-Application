package com.example.dnic.service_or_business.impl.impl;

import com.example.dnic.model.Unit;
import com.example.dnic.model.exception.UnitNotFoundException;
import com.example.dnic.persistence_or_repository.UnitRepository;
import com.example.dnic.service_or_business.impl.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;

    @Autowired

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Unit> findAll() {
        return this.unitRepository.findAll();
    }

    @Override
    public Unit findById(Long id) {
        return this.unitRepository.findById(id)
                .orElseThrow(() -> new UnitNotFoundException(id));
    }
}
