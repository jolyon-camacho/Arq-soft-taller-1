package com.edtech.numlogic.model;

/**
 * Manages game configuration and difficulty levels.
 * This class allows setting dynamic ranges (e.g., 1-10 for beginners,
 * 1-1000 for advanced) without modifying the base code logic.
 */
public class Configuracion {
    private int nivelDificultad;
    private int rangoMinimo;
    private int rangoMaximo;

    /** Level constants for clarity in the controller. */
    public static final int PRINCIPIANTE = 1;
    public static final int AVANZADO = 2;

    /**
     * Default constructor. Sets difficulty to Beginner (1-10).
     */
    public Configuracion() {
        establecerDificultad(PRINCIPIANTE);
    }

    /**
     * Configures the numeric range based on the selected difficulty level.
     * 
     * @param nivel Use Configuracion.PRINCIPIANTE or Configuracion.AVANZADO.
     */
    public void establecerDificultad(int nivel) {
        this.nivelDificultad = nivel;
        if (nivel == AVANZADO) {
            this.rangoMinimo = 1;
            this.rangoMaximo = 1000;
        } else {
            this.rangoMinimo = 1;
            this.rangoMaximo = 10;
        }
    }

    /** @return The lower bound of the range. */
    public int getRangoMinimo() {
        return rangoMinimo;
    }

    /** @return The upper bound of the range. */
    public int getRangoMaximo() {
        return rangoMaximo;
    }

    /** @return The current numeric level ID. */
    public int getNivelDificultad() {
        return nivelDificultad;
    }
}
