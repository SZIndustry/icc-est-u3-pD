import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        runMaze();
    }

    private static void runMaze() {
        boolean[][] predefinedMaze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Cristopher Salinas");
        System.out.println("Laberinto cargado:");
        maze.printMaze();
        System.out.println();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        MazeSolverRecursivoCompletBT solver = new MazeSolverRecursivoCompletBT();
        List<Cell> path = solver.getPath(maze.getMaze(), start, end);
        
        if (path != null) {
            System.out.println("Camino encontrado:");
            System.out.println(path);
            System.out.println();

            // Mostrar laberinto con celdas visitadas
            System.out.println("Laberinto con las celdas visitadas:");
            printVisitedMaze(maze.getMaze(), solver.getVisitedCells());
            System.out.println();

            // Mostrar laberinto con el camino recorrido
            System.out.println("Laberinto con el camino recorrido:");
            printPathMaze(maze.getMaze(), path);
        } else {
            System.out.println("No se encontró camino.");
        }
    }

    private static void printVisitedMaze(boolean[][] maze, Set<Cell> visitedCells) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Cell current = new Cell(i, j);
                if (!maze[i][j]) {
                    System.out.print("* ");
                } else if (visitedCells.contains(current)) {
                    System.out.print("> ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    private static void printPathMaze(boolean[][] maze, List<Cell> path) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Cell current = new Cell(i, j);
                if (!maze[i][j]) {
                    System.out.print("* ");
                } else if (path.contains(current)) {
                    System.out.print("> ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}