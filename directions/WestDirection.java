package kata.rover.directions;

import kata.rover.grid.Position;

public class WestDirection extends Direction {
    public char value() {
        return 'W';
    }

    public Direction right() {
        return new NorthDirection();
    }

    public Position forwardFrom(Position position) {
        return position.update(position.x - 1, position.y);
    }

    public Direction left() {
        return new SouthDirection();
    }
}
