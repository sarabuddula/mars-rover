package com.mars.rover.exception;

/**
 * Below Exception is thrown on receiving invalid instruction
 */
public class InvalidInstructionException extends MarsRoverException{

    /**
     * Below method provides message and cause of exception
     * @param message
     * @param t
     */
    public InvalidInstructionException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * Below method provides message and cause of exception is not provided
     * @param message
     */
    public InvalidInstructionException(String message) {
        super(message);
    }
}
