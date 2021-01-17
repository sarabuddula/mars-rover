package com.mars.rover;

import com.mars.rover.constant.Instruction;
import com.mars.rover.model.Instructions;
import com.mars.rover.model.Plateau;
import com.mars.rover.model.Rover;

import java.util.List;
import java.util.Scanner;

/**
 * Below class is the  starting point of execution
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Plateau dimension in format x y , for example : ");
        System.out.print("If x is 5 and y is 5 then mention :" );
        System.out.println("5 5");

        String plateaudimensions = scanner.nextLine();
        Plateau plateau = createPlateau(plateaudimensions);


        while (true) {
            System.out.println("Enter drop information for Rover in form of (x y d) coordinates and direction");
            String dropInfo = scanner.nextLine();

            Rover r = dropRover(plateau, dropInfo);

            System.out.println("Enter instructions , use only L (left), R (right), M (Move)");
            String rawInstructions = scanner.nextLine();
            List<Instruction> instructions = new Instructions(rawInstructions).getInstructions();
            r.processInstructions(instructions);
            System.out.println(r.displayFinalPosition());

            System.out.println("Do you want to drop another Rover (Y/N)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N"))break;
        }
    }

    private static Rover dropRover(Plateau plateau, String dropInfo) {
        Rover r = new Rover();
        r.dropRover(plateau,dropInfo);
        return r;
    }

    private static Plateau createPlateau(String plateaudimensions) {
        String[] dim = plateaudimensions.split(" ");
        int dimX = Integer.parseInt(dim[0]);
        int dimY = Integer.parseInt(dim[1]);
        return new Plateau(dimX, dimY);
    }
}
