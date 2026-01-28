package com.edtech.numlogic.view;

import java.util.Scanner;

/**
 * Handles all user interactions for NumLogic Explorer.
 * Designed to be "robust" against invalid user inputs (errors from children).
 */
public class InterfazUsuario {
    private final Scanner scanner;

    public InterfazUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("[NumLogic] " + mensaje);
    }

    public void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println("   BIENVENIDO A NUMLOGIC EXPLORER   ");
        System.out.println("========================================");
    }

    /**
     * Captures basic text input.
     */
    public String capturarTexto(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }

    /**
     * Captures an integer with robust error handling.
     * Requirement: System must be "a prueba de errores de usuario".
     */
    public int capturarEntero(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("¡Oops! Eso no parece un número. Por favor, intenta de nuevo.");
            }
        }
    }

    /**
     * Shows a hint to the player.
     * 
     * @param esMayor True if the secret number is greater than the guess.
     */
    public void mostrarPista(boolean esMayor) {
        if (esMayor) {
            System.out.println(">> Pista: El número secreto es MAYOR.");
        } else {
            System.out.println(">> Pista: El número secreto es MENOR.");
        }
    }

    public void mostrarResultadoFinal(int intentos, long tiempo, int numeroSecreto) {
        System.out.println("\n****************************************");
        System.out.println("¡FELICITACIONES! Has encontrado el número: " + numeroSecreto);
        System.out.println("Resumen de tu aventura:");
        System.out.println("- Intentos totales: " + intentos);
        System.out.println("- Tiempo transcurrido: " + tiempo + " segundos");

        // Efficiency calculation (very basic for kids)
        String eficiencia = (intentos <= 5) ? "¡Excelente!" : (intentos <= 10) ? "¡Muy bien!" : "¡Puedes mejorar!";
        System.out.println("- Eficiencia de búsqueda: " + eficiencia);
        System.out.println("****************************************\n");
    }

    public boolean preguntarReintento() {
        System.out.print("¿Quieres jugar otra vez? (s/n): ");
        String respuesta = scanner.nextLine().toLowerCase();
        return respuesta.startsWith("s");
    }
}
