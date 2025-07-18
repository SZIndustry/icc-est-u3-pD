import java.util.*;

public class MazeSolverRecursivo implements Maze.MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        List<Cell> path = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();

        if (findPath(grid, start, end, path, visited)) {
            Collections.reverse(path); // Opcional, para que el camino esté de start a end
            return path;
        }

        return null;
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, Set<Cell> visited) {
        if (current.getRow() < 0 || current.getRow() >= grid.length ||
            current.getCol() < 0 || current.getCol() >= grid[0].length ||
            !grid[current.getRow()][current.getCol()] ||
            visited.contains(current)) {
            return false;
        }

        visited.add(current);

        if (current.equals(end)) {
            path.add(current);
            return true;
        }

        if (findPath(grid, new Cell(current.getRow() + 1, current.getCol()), end, path, visited) ||
            findPath(grid, new Cell(current.getRow() - 1, current.getCol()), end, path, visited) ||
            findPath(grid, new Cell(current.getRow(), current.getCol() + 1), end, path, visited) ||
            findPath(grid, new Cell(current.getRow(), current.getCol() - 1), end, path, visited)) {
            path.add(current);
            return true;
        }

        return false;
    }
}
