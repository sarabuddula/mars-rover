package com.mars.rover.model;

import com.mars.rover.constant.Direction;
import com.mars.rover.constant.Instruction;
import com.mars.rover.exception.CrossingPlateauBoundariesException;
import com.mars.rover.exception.MarsRoverException;

import java.util.List;

/**
 * Below class represents Rover with dependencies mentioned below
 * <p>
 *     Each instance of {@link Rover} should know about it's
 *     <ul>
 *         <li>{@link Position} on the plateau</li>
 *         <li>{@link Instructions} which are intended to perform on rover</li>
 *         <li>{@link Plateau} dimensions about plateau</li>
 *     </ul>
 * </p>
 */
public class Rover {
    private Plateau plateau;
    private Position position;
    private Direction heading;

    public Rover() { }

    public void dropRover(Plateau plateau, String args) {
        String[] parts = args.split(" ");

        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        Direction h = initialDirection(parts[2].charAt(0));

        dropRover(plateau, new Position(x, y), h);
    }

    public void dropRover(Plateau plateau, Position p, Direction h) {
        if (!p.IsOnPlateau(plateau)) {
            throw new CrossingPlateauBoundariesException("Rover is not being placed on plateau");
        }

        if (plateau.isOccupied(p)) {
            throw new MarsRoverException("Given Coordinates are already occupied");
        }

        this.plateau = plateau;
        position = p;
        heading = h;

        plateau.dropRoverOntoThisPlateau(this);
    }

    public void dropRover(Plateau plateau, int posX, int posY, char heading) {
        Direction h = initialDirection(heading);

        dropRover(plateau, new Position(posX, posY), h);
    }

    public String displayFinalPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(displayPosition());

        return sb.toString();
    }

    public String displayPosition() {
        if (position == null || heading == null) {
            return "Not dropped yet.";
        }

        return position.toString() + " " + fromDirections(heading);
    }


    public boolean hasPosition(Position pos) {
        return position.isEqual(pos);
    }

    public void processInstructions(List<Instruction> instructions) {
        for (Instruction i : instructions) {
            processInstruction(i);
        }
    }

    private void processInstruction(Instruction instruction) {
        if (position == null || heading == null) {
            throw new MarsRoverException("Empty instructions received");
        }

        switch (instruction) {
            case LEFT: turnLeft(); break;
            case MOVE: moveForward(); break;
            case RIGHT: turnRight(); break;
        }
    }

    private void turnLeft() {
        switch (heading) {
            case EAST: heading = Direction.NORTH; break;
            case NORTH: heading = Direction.WEST; break;
            case SOUTH: heading = Direction.EAST; break;
            case WEST: heading = Direction.SOUTH; break;
        }
    }

    private void turnRight() {
        switch (heading) {
            case EAST: heading = Direction.SOUTH; break;
            case NORTH: heading = Direction.EAST; break;
            case SOUTH: heading = Direction.WEST; break;
            case WEST: heading = Direction.NORTH; break;
        }
    }

    private void moveForward() {
        Position newPosition = position.moveForward(heading);

        if (!newPosition.IsOnPlateau(plateau)) {
            throw new CrossingPlateauBoundariesException("By moving forward, you rover will be crossing boundaries of plateau");
        }

        position = newPosition;
    }

    private static Direction initialDirection(char heading) {
        switch (heading) {
            case 'N': return Direction.NORTH;
            case 'W': return Direction.WEST;
            case 'S': return Direction.SOUTH;
            case 'E': return Direction.EAST;
            default: throw new RuntimeException("Unsupported character '" + heading + "'!");
        }
    }

    private static char fromDirections(Direction heading) {
        switch (heading) {
            case NORTH: return 'N';
            case WEST: return 'W';
            case SOUTH: return 'S';
            case EAST: return 'E';
            default: return ' ';
        }
    }

}
