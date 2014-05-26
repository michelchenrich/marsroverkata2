package kata.rover;

import kata.rover.grid.ObstacleFoundException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RoverTest {
    private Rover rover;

    @Test
    public void moveNorth() {
        givenRoverAt(1, 1, 'N');
        whenExecuting("F");
        thenRoverShouldBeAt(1, 0, 'N');
    }

    private void givenRoverAt(int x, int y, char n) {
        rover = new Rover(100, 100, x, y, n);
    }

    private void whenExecuting(String commands) {
        rover.execute(commands);
    }

    private void thenRoverShouldBeAt(int x, int expected, char direction) {
        assertEquals(x, rover.x());
        assertEquals(expected, rover.y());
        assertEquals(direction, rover.direction());
    }

    @Test
    public void moveSouth() {
        givenRoverAt(1, 1, 'S');
        whenExecuting("F");
        thenRoverShouldBeAt(1, 2, 'S');
    }

    @Test
    public void moveWest() {
        givenRoverAt(1, 1, 'W');
        whenExecuting("F");
        thenRoverShouldBeAt(0, 1, 'W');
    }

    @Test
    public void moveEast() {
        givenRoverAt(1, 1, 'E');
        whenExecuting("F");
        thenRoverShouldBeAt(2, 1, 'E');
    }

    @Test
    public void moveBackNorth() {
        givenRoverAt(1, 1, 'S');
        whenExecuting("B");
        thenRoverShouldBeAt(1, 0, 'S');
    }

    @Test
    public void moveBackSouth() {
        givenRoverAt(1, 1, 'N');
        whenExecuting("B");
        thenRoverShouldBeAt(1, 2, 'N');
    }

    @Test
    public void moveBackWest() {
        givenRoverAt(1, 1, 'E');
        whenExecuting("B");
        thenRoverShouldBeAt(0, 1, 'E');
    }

    @Test
    public void moveBackEast() {
        givenRoverAt(1, 1, 'W');
        whenExecuting("B");
        thenRoverShouldBeAt(2, 1, 'W');
    }

    @Test
    public void wrapNorth() {
        givenRoverAt(1, 0, 'N');
        whenExecuting("F");
        thenRoverShouldBeAt(1, 99, 'N');
    }

    @Test
    public void wrapSouth() {
        givenRoverAt(1, 99, 'S');
        whenExecuting("F");
        thenRoverShouldBeAt(1, 0, 'S');
    }

    @Test
    public void wrapWest() {
        givenRoverAt(0, 1, 'W');
        whenExecuting("F");
        thenRoverShouldBeAt(99, 1, 'W');
    }

    @Test
    public void wrapEast() {
        givenRoverAt(99, 1, 'E');
        whenExecuting("F");
        thenRoverShouldBeAt(0, 1, 'E');
    }

    @Test
    public void wrapBackNorth() {
        givenRoverAt(1, 0, 'S');
        whenExecuting("B");
        thenRoverShouldBeAt(1, 99, 'S');
    }

    @Test
    public void wrapBackSouth() {
        givenRoverAt(1, 99, 'N');
        whenExecuting("B");
        thenRoverShouldBeAt(1, 0, 'N');
    }

    @Test
    public void wrapBackWest() {
        givenRoverAt(0, 1, 'E');
        whenExecuting("B");
        thenRoverShouldBeAt(99, 1, 'E');
    }

    @Test
    public void wrapBackEast() {
        givenRoverAt(99, 1, 'W');
        whenExecuting("B");
        thenRoverShouldBeAt(0, 1, 'W');
    }

    @Test
    public void fromNorthTurnWest() {
        givenRoverAt(0, 0, 'N');
        whenExecuting("L");
        thenRoverShouldBeAt(0, 0, 'W');
    }

    @Test
    public void fromWestTurnSouth() {
        givenRoverAt(0, 0, 'W');
        whenExecuting("L");
        thenRoverShouldBeAt(0, 0, 'S');
    }

    @Test
    public void fromSouthTurnEast() {
        givenRoverAt(0, 0, 'S');
        whenExecuting("L");
        thenRoverShouldBeAt(0, 0, 'E');
    }

    @Test
    public void fromEastTurnNorth() {
        givenRoverAt(0, 0, 'E');
        whenExecuting("L");
        thenRoverShouldBeAt(0, 0, 'N');
    }

    @Test
    public void fromNorthTurnEast() {
        givenRoverAt(0, 0, 'N');
        whenExecuting("R");
        thenRoverShouldBeAt(0, 0, 'E');
    }

    @Test
    public void fromEastTurnSouth() {
        givenRoverAt(0, 0, 'E');
        whenExecuting("R");
        thenRoverShouldBeAt(0, 0, 'S');
    }

    @Test
    public void fromSouthTurnWest() {
        givenRoverAt(0, 0, 'S');
        whenExecuting("R");
        thenRoverShouldBeAt(0, 0, 'W');
    }

    @Test
    public void fromWestTurnNorth() {
        givenRoverAt(0, 0, 'W');
        whenExecuting("R");
        thenRoverShouldBeAt(0, 0, 'N');
    }

    @Test
    public void multipleCommands() {
        givenRoverAt(9, 9, 'N');
        whenExecuting("RFFRFFRFFRFFLB");
        thenRoverShouldBeAt(10, 9, 'W');
    }

    @Test(expected = ObstacleFoundException.class)
    public void obstacleHitWhenMovingBackward() {
        givenRoverAt(9, 9, 'N');
        givenObstacleAt(10, 9);
        whenExecuting("LB");
    }

    private void givenObstacleAt(int x, int y) {
        rover.addObstacleAt(x, y);
    }

    @Test(expected = ObstacleFoundException.class)
    public void obstacleHitWhenMovingForward() {
        givenRoverAt(9, 9, 'N');
        givenObstacleAt(10, 9);
        whenExecuting("RF");
    }
}