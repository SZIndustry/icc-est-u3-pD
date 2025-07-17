import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursivo implements Maze.MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        List<Cell> path = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();

        if (findPath(grid, start, end, path, visited)) {
            return path;
        }

        return null;
    }

    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path, Set<Cell> visited) {
        //Validar si la fila esta dentro del Grid
        if (start.getRow() < 0 || start.getRow() >= grid.length ||
            start.getCol() < 0 || start.getCol() >= grid[0].length ||
            !grid[start.getRow()][start.getCol()] ||
            visited.contains(start)) {
            return false;
        }

        visited.add(start); // Marca la celda como visitada

        if (start.getRow() == end.getRow() && start.getCol() == end.getCol()) {
            path.add(start);
            return true;
        }

        if (findPath(grid, new Cell(start.getRow() + 1, start.getCol()), end, path, visited) || 
            findPath(grid, new Cell(start.getRow() - 1, start.getCol()), end, path, visited) || 
            findPath(grid, new Cell(start.getRow(), start.getCol() + 1), end, path, visited) || 
            findPath(grid, new Cell(start.getRow(), start.getCol() - 1), end, path, visited)) { 

            path.add(start); 
            return true;
        }

        return false;
    }
}
