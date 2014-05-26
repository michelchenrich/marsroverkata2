package kata.rover.directions;

import kata.rover.grid.Position;

public class SouthDirection extends Direction {
    public char value() {
        return 'S';
    }

    public Direction right() {
        return new WestDirection();
    }

    public Position forwardFrom(Position position) {
        return position.update(position.x, position.y + 1);
    }

    public Direction left() {
        return new EastDirection();
    }
}
