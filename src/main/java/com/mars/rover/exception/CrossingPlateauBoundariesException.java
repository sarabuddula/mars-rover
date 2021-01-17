package com.mars.rover.exception;

/**
 * Below exception is thrown when given rover crossed boundary of plateau
 */
public class CrossingPlateauBoundariesException extends MarsRoverException{

    /**
     * Below exception is thrown with message and cause of exception
     * @param message
     * @param t
     */
    public CrossingPlateauBoundariesException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * Below exception is thrown with message and cause of exception is not mentioned here.
     * @param message
     */
    public CrossingPlateauBoundariesException(String message) {
        super(message);
    }
}
