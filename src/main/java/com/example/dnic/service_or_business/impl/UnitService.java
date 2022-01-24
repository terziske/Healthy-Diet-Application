package com.example.dnic.service_or_business.impl;

import com.example.dnic.model.Unit;

import java.util.List;

public interface UnitService {
    List<Unit> findAll();
    Unit findById(Long id);
}
