public class Sudoku {
    private static final int tamanio = 9;
    private static final int tamanio_cajita = 3;

    public static boolean resolverSudoku(int[][] tablero) {
        for (int fila = 0; fila < tamanio; fila++) {
            for (int columna = 0; columna < tamanio; columna++) {
                if (tablero[fila][columna] == 0) {
                    for (int numero = 1; numero <= tamanio; numero++) {
                        if (esValido(tablero, fila, columna, numero)) {
                            tablero[fila][columna] = numero;
                            if (resolverSudoku(tablero)) {
                                return true;
                            }
                            tablero[fila][columna] = 0; // Retrocede
                        }
                    }
                    return false; // No hay solucion
                }
            }
        }
        return true; // Celdas llenas
    }

    private static boolean esValido(int[][] tablero, int fila, int columna, int numero) {
        // Verificar fila y columna
        for (int i = 0; i < tamanio; i++) {
            if (tablero[fila][i] == numero || tablero[i][columna] == numero) {
                return false;
            }
        }
        // Verificar cajita 3x3
        int filaInicio = fila - fila % tamanio_cajita;
        int columnaInicio = columna - columna % tamanio_cajita;
        for (int i = 0; i < tamanio_cajita; i++) {
            for (int j = 0; j < tamanio_cajita; j++) {
                if (tablero[filaInicio + i][columnaInicio + j] == numero) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Primer tablero:");
        imprimirTablero(tablero);
        System.out.println();

        if (resolverSudoku(tablero)) {
            System.out.println("Solución encontrada:");
            imprimirTablero(tablero);
        } else {
            System.out.println("No existe solución para este tablero");
        }
    }
}