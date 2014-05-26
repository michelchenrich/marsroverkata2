package kata.rover.directions;

import kata.rover.grid.Position;

public class EastDirection extends Direction {
    public char value() {
        return 'E';
    }

    public Direction right() {
        return new SouthDirection();
    }

    public Position forwardFrom(Position position) {
        return position.update(position.x + 1, position.y);
    }

    public Direction left() {
        return new NorthDirection();
    }
}
