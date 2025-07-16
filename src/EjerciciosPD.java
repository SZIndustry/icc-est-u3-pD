
import java.util.Map;

public class EjerciciosPD {
    public long getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    // Fibbonacci con catching usando diccionarios
    public long getFibonacciPD(int n) {
        Map<Integer, Long> memo = new java.util.HashMap<>();
        return getFibonacciPDHelper(n, memo);
    }

    private long getFibonacciPDHelper(int n, Map<Integer, Long> memo) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result = getFibonacciPDHelper(n - 1, memo) + getFibonacciPDHelper(n - 2, memo);
        memo.put(n, result);
        return result;
    }
}
