package kata.rover.commands;

import kata.rover.directions.Direction;
import kata.rover.grid.Position;

import java.util.HashMap;
import java.util.Map;

public abstract class Command {
    private final static Map<Character, Command> commands;

    static {
        commands = new HashMap<Character, Command>();
        commands.put('F', new ForwardCommand());
        commands.put('B', new BackwardCommand());
        commands.put('R', new TurnRightCommand());
        commands.put('L', new TurnLeftCommand());
    }


    public static Command byValue(char command) {
        return commands.get(command);
    }

    public abstract void executeOn(RoverMutator rover, Position position, Direction direction);
}
