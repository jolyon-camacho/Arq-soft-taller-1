package com.edtech.numlogic.model;

/**
 * Core engine for a single match of NumLogic Explorer.
 * Encapsulates the game state, including the secret number, attempt counter,
 * and time tracking for basic analytics.
 */
public class Juego {
    private int numeroSecreto;
    private int intentosRealizados;
    private boolean juegoActivo;
    private final Configuracion configuracion;
    private final GeneradorAleatorio generador;
    private long tiempoInicio;

    /**
     * Creates a match instance with specific difficulty settings.
     * 
     * @param configuracion The range settings for this game.
     * @param generador     The engine used to pick the secret number.
     */
    public Juego(Configuracion configuracion, GeneradorAleatorio generador) {
        this.configuracion = configuracion;
        this.generador = generador;
        this.juegoActivo = false;
    }

    /**
     * Resets state and picks a new secret number to start the match.
     */
    public void iniciarPartida() {
        this.numeroSecreto = generador.generarNumero(
                configuracion.getRangoMinimo(),
                configuracion.getRangoMaximo());
        this.intentosRealizados = 0;
        this.juegoActivo = true;
        this.tiempoInicio = System.currentTimeMillis();
    }

    /**
     * Checks the player's guess against the secret number.
     * 
     * @param numero The input guessed by the child.
     * @return 0 if correct, 1 if secret is higher, -1 if secret is lower.
     * @throws IllegalStateException If called before starting the game.
     */
    public int validarIntento(int numero) {
        if (!juegoActivo) {
            throw new IllegalStateException("El juego no está activo.");
        }

        intentosRealizados++;

        if (numero == numeroSecreto) {
            juegoActivo = false;
            return 0;
        }

        return (numeroSecreto > numero) ? 1 : -1;
    }

    /** @return Total attempts made so far. */
    public int getIntentosRealizados() {
        return intentosRealizados;
    }

    /** @return True if the game is currently running. */
    public boolean isJuegoActivo() {
        return juegoActivo;
    }

    /** @return The secret number (exposed for auditing/testing). */
    public int getNumeroSecreto() {
        return numeroSecreto;
    }

    /** @return Elapsed time in seconds since the match started. */
    public long getTiempoTranscurrido() {
        if (juegoActivo || intentosRealizados > 0) {
            return (System.currentTimeMillis() - tiempoInicio) / 1000;
        }
        return 0;
    }
}
