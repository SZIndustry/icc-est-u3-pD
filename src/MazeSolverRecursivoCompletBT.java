import java.util.*;

public class MazeSolverRecursivoCompletBT implements Maze.MazeSolver {

    private boolean[][] grid;
    private List<Cell> path;
    private Set<Cell> visited;
    private Cell end;
    private List<Cell> optimalPath;

    public MazeSolverRecursivoCompletBT() {
        this.path = new ArrayList<>();
        this.visited = new HashSet<>();
        this.optimalPath = new ArrayList<>();
    }

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        this.grid = grid;
        this.end = end;
        this.path.clear();
        this.visited.clear();
        this.optimalPath.clear();

        if (findPath(start)) {
            // Guardamos una copia del camino óptimo encontrado
            this.optimalPath = new ArrayList<>(path);
            
            System.out.println("RUTA VISITADA");
            System.out.println(visited);
            System.out.println("RUTA OPTIMA");
            System.out.println(optimalPath);
            System.out.println();
            
            return optimalPath;
        }

        return null;
    }

    private boolean findPath(Cell current) {
        if (!isInMaze(current) || !isValid(current)) {
            return false;
        }

        path.add(current);
        visited.add(current);

        if (current.equals(end)) {
            return true;
        }

        // Probamos las 4 direcciones posibles
        if (findPath(new Cell(current.getRow() + 1, current.getCol())) || // Abajo
            findPath(new Cell(current.getRow() - 1, current.getCol())) || // Arriba
            findPath(new Cell(current.getRow(), current.getCol() + 1)) || // Derecha
            findPath(new Cell(current.getRow(), current.getCol() - 1))) {  // Izquierda
            return true;
        }

        // Backtracking: eliminamos la celda si no lleva a la solución
        path.remove(path.size() - 1);
        return false;
    }

    private boolean isInMaze(Cell cell) {
        return cell.getRow() >= 0 && cell.getRow() < grid.length &&
               cell.getCol() >= 0 && cell.getCol() < grid[0].length;
    }

    private boolean isValid(Cell cell) {
        return grid[cell.getRow()][cell.getCol()] && !visited.contains(cell);
    }

    public Set<Cell> getVisitedCells() {
        return visited;
    }

    public List<Cell> getOptimalPath() {
        return optimalPath;
    }
}