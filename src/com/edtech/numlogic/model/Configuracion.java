package com.edtech.numlogic.model;

/**
 * Manages game configuration and difficulty levels.
 * Requirements: Manage ranges dynamic without modifying base code.
 */
public class Configuracion {
    private int nivelDificultad;
    private int rangoMinimo;
    private int rangoMaximo;

    public static final int PRINCIPIANTE = 1;
    public static final int AVANZADO = 2;

    public Configuracion() {
        // Default to Beginner
        establecerDificultad(PRINCIPIANTE);
    }

    /**
     * Sets range based on difficulty.
     * 
     * @param nivel 1 for Beginner, 2 for Advanced
     */
    public void establecerDificultad(int nivel) {
        this.nivelDificultad = nivel;
        if (nivel == AVANZADO) {
            this.rangoMinimo = 1;
            this.rangoMaximo = 1000; // Requirement: 1-1000 for advanced
        } else {
            this.rangoMinimo = 1;
            this.rangoMaximo = 10; // Requirement: 1-10 for beginners
        }
    }

    public int getRangoMinimo() {
        return rangoMinimo;
    }

    public int getRangoMaximo() {
        return rangoMaximo;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }
}
