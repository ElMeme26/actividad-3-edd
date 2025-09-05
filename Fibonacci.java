public class Fibonacci {
    public static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser mayor o igual a 0");
        }
        if (n == 0) { // Caso base
            return 0;
        }
        if (n == 1) { // Caso base
            return 1;
        }
        return fib(n - 1) + fib(n - 2); // Caso recursivo
    }

    public static void main(String[] args) {
        // Pruebas de la función Fibonacci
        System.out.println("Fibonacci de 0: " + fib(0));
        System.out.println("Fibonacci de 1: " + fib(1));
        System.out.println("Fibonacci de 2: " + fib(2));
        System.out.println("Fibonacci de 3: " + fib(3));
        System.out.println("Fibonacci de 4: " + fib(4));
        System.out.println("Fibonacci de 5: " + fib(5));
        System.out.println("Fibonacci de 10: " + fib(10));
    }
}