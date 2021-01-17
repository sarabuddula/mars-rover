package com.mars.rover.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Below class represents a Plateau . With attributes
 * <p>
 *      Class level <code>xCoordinate</code> & <code>yCoordinate</code> variables
 *      represents the position of {@link Rover}, below holds {@link Rover} on it.
 * </p>
 */
public class Plateau {

    private int xCoordinate;
    private int yCoordinate;

    private List<Rover> roverList = new ArrayList<>();

    public Plateau(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void dropRoverOntoThisPlateau(Rover rover) {
        roverList.add(rover);
    }

    public boolean areYouDroppingRoverOntoAlreadyOccupiedPosition(Position position) {
        for (Rover rover: roverList) {
            if (rover.hasPosition(position)) return true;
        }
        return false;
    }

    public boolean isOccupied(Position position) {
        return xCoordinate == position.getxCoordinate() && yCoordinate == position.getyCoordinate();
    }


    public int getxCoordinate() { return xCoordinate; }

    public void setxCoordinate(int xCoordinate) { this.xCoordinate = xCoordinate; }

    public int getyCoordinate() { return yCoordinate; }

    public void setyCoordinate(int yCoordinate) { this.yCoordinate = yCoordinate; }

}
