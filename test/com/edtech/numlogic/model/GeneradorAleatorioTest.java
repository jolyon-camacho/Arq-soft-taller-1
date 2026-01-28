package com.edtech.numlogic.model;

/**
 * Unit tests for GeneradorAleatorio.
 * Since we don't have a build system configured,
 * these are written to be compatible with JUnit 5.
 */
public class GeneradorAleatorioTest {

    // Simulating JUnit @Test behavior with a manual check for now
    // or just providing the standard test structure.

    public void testGenerarNumeroDentroDelRango() {
        GeneradorAleatorio generador = new GeneradorAleatorio();
        int min = 1;
        int max = 10;

        for (int i = 0; i < 100; i++) {
            int numero = generador.generarNumero(min, max);
            if (numero < min || numero > max) {
                throw new RuntimeException("ERROR: Número fuera de rango: " + numero);
            }
        }
        System.out.println("testGenerarNumeroDentroDelRango: PASSED");
    }

    public void testGenerarNumeroRangoIgual() {
        GeneradorAleatorio generador = new GeneradorAleatorio();
        int min = 5;
        int max = 5;
        int numero = generador.generarNumero(min, max);

        if (numero != 5) {
            throw new RuntimeException("ERROR: Debería ser 5, pero fue: " + numero);
        }
        System.out.println("testGenerarNumeroRangoIgual: PASSED");
    }

    public static void main(String[] args) {
        GeneradorAleatorioTest test = new GeneradorAleatorioTest();
        try {
            test.testGenerarNumeroDentroDelRango();
            test.testGenerarNumeroRangoIgual();
            System.out.println("¡Todas las pruebas de GeneradorAleatorio pasaron!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
