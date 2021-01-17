import com.mars.rover.constant.Instruction;
import com.mars.rover.exception.CrossingPlateauBoundariesException;
import com.mars.rover.exception.InvalidInstructionException;
import com.mars.rover.exception.MarsRoverException;
import com.mars.rover.model.Instructions;
import com.mars.rover.model.Plateau;
import com.mars.rover.model.Rover;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class MarsRoverTest {

    //Initialize plateau with given coordinates (5,5)
    private Plateau plateau = new Plateau(5,5);

    @Test
    public void testForRoverMove() {
        Rover rover = new Rover();
        rover.dropRover(plateau, "1 2 N");

        rover.processInstructions(convertToList("LMLMLMLMM"));
        assertEquals("1 3 N", rover.displayFinalPosition());
    }

    private List<Instruction> convertToList(String instruction) {
        return new Instructions(instruction).getInstructions();
    }

    @Test
    public void moving_rover_beyond_throws_exception() {
        Rover rover = new Rover();
        rover.dropRover(plateau, 2, 2, 'N');

        try {
            //rover.processInstructions("MMMMMMMM");
            rover.processInstructions(convertToList("MMMMMMMM"));
        }
        catch (CrossingPlateauBoundariesException ex) {
            assertEquals("By moving forward, you rover will be crossing boundaries of plateau", ex.getMessage());
        }
    }

    @Test
    public void dropping_rover_somewhere() {
        Rover rover = new Rover();
        try {
            rover.dropRover(plateau, 6, 6, 'N');
        }
        catch (CrossingPlateauBoundariesException ex) {
            assertEquals("Rover is not being placed on plateau", ex.getMessage());
        }
    }


    @Test
    public void wrongInstructionPassed() {
        Rover rover = new Rover();
        try {
            rover.processInstructions(convertToList("XXXX"));
        }
        catch (InvalidInstructionException ex) {
            assertEquals("Received instruction X which is not valid",ex.getMessage());
        }
    }

    @Test
    public void testMarsRoverException() {
        Rover rover1 = new Rover();
        Rover rover2 = new Rover();
        try {
            rover1.dropRover(plateau, 5, 5, 'N');
            rover2.dropRover(plateau, 5, 5, 'N');
        }catch (MarsRoverException ex) {
            assertEquals("Given Coordinates are already occupied",ex.getMessage());
        }
    }

}
