import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MoveRoverTest {


    @Test
    public void moveRoverWhenCalledForwardBackwardRoverMethode() throws IOException {

        Rover rover = new Rover(1, 1);
        //if the rover is moving forward
        rover.moveRoverForwardBackward(true, false);
        Assert.assertEquals(2, rover.getX());

        //if the rover is moving backward
        rover.moveRoverForwardBackward(false, true);
        Assert.assertEquals(1, rover.getX());

    }

    @Test
    public void moveRoverWhenCalledLeftRightRoverMethode() throws IOException {
        Rover rover = new Rover(1, 1);

        //if the rover is moving left
        rover.moveRoverLeftRight(true, false);
        Assert.assertEquals(2, rover.getY());

        //if the rover is moving right
        rover.moveRoverLeftRight(false, true);
        Assert.assertEquals(1, rover.getY());
    }

    @Test
    public void testWhenRoverArrivedAtEdges() throws IOException {

        Rover rover = new Rover(8, 1);

        //if the rover is moving forward and on edges
        rover.moveRoverForwardBackward(true, false);
        Assert.assertEquals(1, rover.getX());
        Assert.assertEquals(1, rover.getY());

        //if the rover is moving backward and on edges

        rover.moveRoverForwardBackward(false, true);

        Assert.assertEquals(8, rover.getX());
        Assert.assertEquals(1, rover.getY());

        //if the rover is moving left and on edges
        rover.setY(8);

        rover.moveRoverLeftRight(true, false);
        Assert.assertEquals(8, rover.getX());
        Assert.assertEquals(1, rover.getY());

        //if the rover is moving right and on edges
        rover.moveRoverLeftRight(false, true);
        Assert.assertEquals(8, rover.getX());
        Assert.assertEquals(8, rover.getY());

    }

    @Test(expected = IOException.class)
    public void testWhenRoverEncountersObstacle() throws IOException {

        Rover r = new Rover(4,5);
        //if rover is moving to obstacle
        r.moveRoverLeftRight(false,true);
    }

}
