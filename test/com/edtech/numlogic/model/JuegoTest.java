package com.edtech.numlogic.model;

/**
 * Unit tests for the core game logic (Juego).
 */
public class JuegoTest {

    public void testValidarIntentoCorrecto() {
        Configuracion config = new Configuracion();
        // Use a mock/stub style for the generator or just use the real one and check
        // results
        GeneradorAleatorio generador = new GeneradorAleatorio();
        Juego juego = new Juego(config, generador);

        juego.iniciarPartida();
        int secreto = juego.getNumeroSecreto();

        int resultado = juego.validarIntento(secreto);

        if (resultado != 0) {
            throw new RuntimeException("ERROR: El resultado debería ser 0 (acierto)");
        }
        if (juego.isJuegoActivo()) {
            throw new RuntimeException("ERROR: El juego debería estar inactivo después de acertar");
        }
        System.out.println("testValidarIntentoCorrecto: PASSED");
    }

    public void testPistaMayor() {
        Configuracion config = new Configuracion();
        GeneradorAleatorio generador = new GeneradorAleatorio();
        Juego juego = new Juego(config, generador);
        juego.iniciarPartida();

        int secreto = juego.getNumeroSecreto();
        // Test with a number lower than secret to get "Higher" hint (result > 0)
        int intento = secreto - 1;

        // Ensure we handle the boundary if secret is already the minimum
        if (intento >= config.getRangoMinimo()) {
            int resultado = juego.validarIntento(intento);
            if (resultado <= 0) {
                throw new RuntimeException("ERROR: El resultado debería ser positivo (el secreto es mayor)");
            }
            System.out.println("testPistaMayor: PASSED");
        } else {
            System.out.println("testPistaMayor: SKIPPED (Secret was min value)");
        }
    }

    public void testConteoIntentos() {
        Juego juego = new Juego(new Configuracion(), new GeneradorAleatorio());
        juego.iniciarPartida();

        juego.validarIntento(-1); // Intentional fail
        juego.validarIntento(-1); // Intentional fail

        if (juego.getIntentosRealizados() != 2) {
            throw new RuntimeException("ERROR: Deberían haber 2 intentos, hay: " + juego.getIntentosRealizados());
        }
        System.out.println("testConteoIntentos: PASSED");
    }

    public static void main(String[] args) {
        JuegoTest test = new JuegoTest();
        try {
            test.testValidarIntentoCorrecto();
            test.testPistaMayor();
            test.testConteoIntentos();
            System.out.println("¡Todas las pruebas de Juego pasaron!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
