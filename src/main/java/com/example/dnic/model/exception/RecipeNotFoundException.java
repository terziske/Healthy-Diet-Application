package com.example.dnic.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(Long id) {
        super(String.format("Recipe with %d was not found!", id));
    }
}
