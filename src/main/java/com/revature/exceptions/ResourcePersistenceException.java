package com.revature.exceptions;

public class ResourcePersistenceException extends RuntimeException {
    public ResourcePersistenceException(String message) {
        super(message);
    }

    public ResourcePersistenceException() {
        super("Resource already in database!");
    }
}
