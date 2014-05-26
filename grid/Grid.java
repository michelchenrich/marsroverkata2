package kata.rover.grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final int width;
    private final int height;
    private final List<Position> obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new ArrayList<Position>();
    }

    public void addObstacleAt(int x, int y) {
        this.obstacles.add(at(x, y));
    }

    public Position at(int x, int y) {
        throwIfIsObstacle(x, y);
        return new Position(this, wrap(x, width), wrap(y, height));
    }

    private void throwIfIsObstacle(int x, int y) {
        for (Position obstacle : obstacles)
            if (obstacle.x == x && obstacle.y == y)
                throw new ObstacleFoundException();
    }

    private int wrap(int coordinate, int limit) {
        if (coordinate < 0) return limit - 1;
        else if (coordinate >= limit) return 0;
        return coordinate;
    }
}
