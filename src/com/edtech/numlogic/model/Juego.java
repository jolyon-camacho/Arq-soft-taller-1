package com.edtech.numlogic.model;

/**
 * Core logic of the NumLogic Explorer game.
 * Maintains game state and validates guesses.
 */
public class Juego {
    private int numeroSecreto;
    private int intentosRealizados;
    private boolean juegoActivo;
    private final Configuracion configuracion;
    private final GeneradorAleatorio generador;
    private long tiempoInicio;

    public Juego(Configuracion configuracion, GeneradorAleatorio generador) {
        this.configuracion = configuracion;
        this.generador = generador;
        this.juegoActivo = false;
    }

    public void iniciarPartida() {
        this.numeroSecreto = generador.generarNumero(
                configuracion.getRangoMinimo(),
                configuracion.getRangoMaximo());
        this.intentosRealizados = 0;
        this.juegoActivo = true;
        this.tiempoInicio = System.currentTimeMillis();
    }

    /**
     * Validates a player's guess.
     * 
     * @param numero The number guessed by the player.
     * @return 0 if correct, negative if secret is lower, positive if secret is
     *         higher.
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

    public int getIntentosRealizados() {
        return intentosRealizados;
    }

    public boolean isJuegoActivo() {
        return juegoActivo;
    }

    public int getNumeroSecreto() {
        // Provided for testing or "cheating" if needed, but usually kept private
        return numeroSecreto;
    }

    public long getTiempoTranscurrido() {
        if (juegoActivo) {
            return (System.currentTimeMillis() - tiempoInicio) / 1000;
        }
        return 0; // Or calculate total duration if stopped
    }
}
