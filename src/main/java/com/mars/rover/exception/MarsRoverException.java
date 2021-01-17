package com.mars.rover.exception;

/**
 * Base Exception from which all specific exceptions are extended
 */
public class MarsRoverException extends RuntimeException{

    /**
     * Below exception is thrown with message and cause of exception
     * @param message
     * @param t
     */
    public  MarsRoverException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * Below exception is thrown with message and cause of exception is not mentioned here.
     * @param message
     */
    public MarsRoverException(String message) {
        super(message);
    }
}
