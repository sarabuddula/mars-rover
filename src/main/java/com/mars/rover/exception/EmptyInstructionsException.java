package com.mars.rover.exception;

/**
 * Below exception is thrown whenever empty instruction set is received for {@link com.mars.rover.model.Rover}
 */
public class EmptyInstructionsException extends MarsRoverException{

    /**
     * Below method provides message and cause of exception
     * @param message
     * @param t
     */
    public EmptyInstructionsException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * Below method provides message and cause of exception is not provided
     * @param message
     */
    public EmptyInstructionsException(String message) {
        super(message);
    }
}
