package com.mars.rover.model;

import com.mars.rover.constant.Instruction;
import com.mars.rover.exception.EmptyInstructionsException;
import com.mars.rover.exception.InvalidInstructionException;
import com.mars.rover.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Below model represents set of instructions performed on each {@link Rover}.
 * Each instance of {@link Instructions} represent list of operations that
 * will be performed on Rover
 */
public class Instructions {

    private String instructions;
    /**
     * Input received to perform on particular Rover.
     * @param instructionLine
     */
    public Instructions(String instructionLine) {
        this.instructions = instructionLine;
    }

    /**
     * Below method on called over a rover return list of instructions intended to perform on it.
     * @return <code>List<Instructions></code> containing instructions
     */
    public List<Instruction> getInstructions() {
        if (StringUtil.isEmpty(instructions)) {
            throw new EmptyInstructionsException("No instructions available to perform on Rover.");
        }

        List<Instruction> instructionList = new ArrayList<>();

        for(char instruction : instructions.toCharArray()) {
            switch(instruction) {
                case 'L': instructionList.add(Instruction.LEFT);break;
                case 'R': instructionList.add(Instruction.RIGHT);break;
                case 'M': instructionList.add(Instruction.MOVE);break;
                default:
                    throw new InvalidInstructionException(String.format("Received instruction %s which is not valid",instruction));
            }
        }
        return instructionList;
    }

}
