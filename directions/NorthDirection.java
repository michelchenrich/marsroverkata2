package kata.rover.directions;

import kata.rover.grid.Position;

public class NorthDirection extends Direction {
    public char value() {
        return 'N';
    }

    public Direction right() {
        return new EastDirection();
    }

    public Position forwardFrom(Position position) {
        return position.update(position.x, position.y - 1);
    }

    public Direction left() {
        return new WestDirection();
    }
}
