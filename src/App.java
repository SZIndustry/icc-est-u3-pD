

public class App {
    public static void main(String[] args) throws Exception {
        runEjerciciosPD();

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
}
