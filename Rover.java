package kata.rover;

import kata.rover.commands.Command;
import kata.rover.commands.RoverMutator;
import kata.rover.directions.Direction;
import kata.rover.grid.Grid;
import kata.rover.grid.Position;

public class Rover {
    private final Mutator mutator;
    private final Grid grid;
    private Position position;
    private Direction direction;

    public Rover(int gridWidth, int gridHeight, int x, int y, char direction) {
        this.mutator = new Mutator();
        this.grid = new Grid(gridWidth, gridHeight);
        this.position = grid.at(x, y);
        this.direction = Direction.byValue(direction);
    }

    public void addObstacleAt(int x, int y) {
        grid.addObstacleAt(x, y);
    }

    public int x() {
        return position.x;
    }

    public int y() {
        return position.y;
    }

    public char direction() {
        return direction.value();
    }

    public void execute(String commands) {
        for (char command : commands.toCharArray()) {
            Command.byValue(command).executeOn(mutator, position, direction);
        }
    }

    private class Mutator implements RoverMutator {
        public void setPosition(Position position) {
            Rover.this.position = position;
        }

        public void setDirection(Direction direction) {
            Rover.this.direction = direction;
        }
    }
}