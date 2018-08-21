package com.datasource.operations.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QueryException extends  RuntimeException {
    public QueryException(String message) {
        super(message);
    }
}
