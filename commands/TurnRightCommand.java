package kata.rover.commands;

import kata.rover.directions.Direction;
import kata.rover.grid.Position;

public class TurnRightCommand extends Command {
    public void executeOn(RoverMutator rover, Position position, Direction direction) {
        rover.setDirection(direction.right());
    }
}
