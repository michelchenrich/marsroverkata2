package kata.rover.directions;

import kata.rover.grid.Position;

import java.util.HashMap;
import java.util.Map;

public abstract class Direction {
    private final static Map<Character, Direction> directions;

    static {
        directions = new HashMap<Character, Direction>();
        directions.put('N', new NorthDirection());
        directions.put('E', new EastDirection());
        directions.put('W', new WestDirection());
        directions.put('S', new SouthDirection());
    }

    public static Direction byValue(char direction) {
        return directions.get(direction);
    }

    public abstract char value();

    public abstract Direction right();

    public Position backwardFrom(Position position) {
        return left().left().forwardFrom(position);
    }

    public abstract Position forwardFrom(Position position);

    public abstract Direction left();
}
