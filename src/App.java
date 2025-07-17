
import java.util.Arrays;
import java.util.List;



public class App {
    public static void main(String[] args) throws Exception {
        //runEjerciciosPD();
        runMaze();

    }

    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        System.out.println("Fibonnaci recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonacci(5);
        long end = System.nanoTime();
        long duration = (end - start);
        System.out.println("Resultados: " + resultado + " en timepo " + duration + " nanosegundos");

        System.out.println("Fibonnaci recursivo catching");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFibonacciPD(100);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("Resultados fibonnacci de: 100 "  + resultado + " en timepo " + duration + " nanosegundos");

        }

    private static void runMaze() {
        boolean[][] predefinedMaze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}
        };

        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado ");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        List<Maze.MazeSolver> solvers = Arrays.asList(
            new MazeSolverRecursivo()
        );

        Maze.MazeSolver solver = solvers.get(0);
        List<Cell> path = solver.getPath(maze.getMaze(), start, end);
        System.out.println("Camino encontrado:");
        System.out.println(path);
    }
}
