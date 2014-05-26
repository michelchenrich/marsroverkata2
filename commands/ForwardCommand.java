package kata.rover.commands;

import kata.rover.directions.Direction;
import kata.rover.grid.Position;

public class ForwardCommand extends Command {
    public void executeOn(RoverMutator rover, Position position, Direction direction) {
        rover.setPosition(direction.forwardFrom(position));
    }
}
