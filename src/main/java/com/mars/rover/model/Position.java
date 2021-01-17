package com.mars.rover.model;

import com.mars.rover.constant.Direction;

/**
 * Below class specifies {@link Rover} position on {@link Plateau}
 */
public class Position {

    private int xCoordinate;
    private int yCoordinate;

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Position(Position other) {
        this.xCoordinate = other.xCoordinate;
        this.yCoordinate = other.yCoordinate;
    }

    public boolean isEqual(Position other) {
        return xCoordinate == other.xCoordinate && yCoordinate== other.yCoordinate;
    }

    public boolean IsOnPlateau(Plateau p) {
        if (xCoordinate < 0 || xCoordinate > p.getxCoordinate()) {
            return false;
        }

        if (yCoordinate < 0 || yCoordinate > p.getyCoordinate()) {
            return false;
        }

        return true;
    }

    public Position moveForward(Direction direction) {
        Position newPosition = null;

        switch (direction) {
            case EAST: newPosition = new Position(xCoordinate + 1, yCoordinate); break;
            case NORTH: newPosition = new Position(xCoordinate, yCoordinate + 1); break;
            case SOUTH: newPosition = new Position(xCoordinate, yCoordinate - 1); break;
            case WEST: newPosition = new Position(xCoordinate - 1, yCoordinate); break;
        }

        return newPosition;
    }

    public int getxCoordinate() { return xCoordinate; }

    public void setxCoordinate(int xCoordinate) { this.xCoordinate = xCoordinate; }

    public int getyCoordinate() { return yCoordinate; }

    public void setyCoordinate(int yCoordinate) { this.yCoordinate = yCoordinate; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append(xCoordinate).append(" ").append(yCoordinate).toString();
    }
}
