package kata.rover.grid;

public class Position {
    public final int x;
    public final int y;
    private final Grid grid;

    public Position(Grid grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
    }

    public Position update(int x, int y) {
        return grid.at(x, y);
    }
}
