package com.example.dnic.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UnitNotFoundException extends RuntimeException {
    public UnitNotFoundException(Long id) {
        super(String.format("Unit with id %d is not found!", id));
    }
}
