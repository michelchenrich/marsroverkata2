package kata.rover.commands;

import kata.rover.directions.Direction;
import kata.rover.grid.Position;

public interface RoverMutator {
    void setPosition(Position position);

    void setDirection(Direction direction);
}
