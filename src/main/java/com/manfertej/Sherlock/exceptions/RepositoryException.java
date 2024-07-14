package com.manfertej.Sherlock.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class RepositoryException extends Exception {

    private final HttpStatus status;

    public RepositoryException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
