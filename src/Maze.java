
import java.util.Arrays;
import java.util.List;

public class Maze {
    private boolean[][] maze;

    public Maze(boolean[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (boolean[] i : maze) {
            for (boolean cell : i) {
                System.out.print(cell ? "- " : "* ");
            }
            System.out.println();
        }
    }


    

    public boolean[][] getMaze() {
        return maze;
    }

    public interface MazeSolver {
        List<Cell> getPath(boolean[][] grid, Cell start, Cell end);

    }

    @Override
    public String toString() {
        return "Maze [maze=" + Arrays.toString(maze) + "]";
    }
}