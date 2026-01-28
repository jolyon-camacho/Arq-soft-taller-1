package com.edtech.numlogic.model;

import java.util.Random;

/**
 * Utility class for secure and fair random number generation.
 * Separated from the game state to ensure modularity and ease of testing.
 */
public class GeneradorAleatorio {
    private final Random random;

    /**
     * Initializes the random engine.
     */
    public GeneradorAleatorio() {
        this.random = new Random();
    }

    /**
     * Generates an integer between min and max (inclusive).
     * 
     * @param min The minimum possible value.
     * @param max The maximum possible value.
     * @return A random integer within the bounds.
     * @throws IllegalArgumentException if min > max.
     */
    public int generarNumero(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("El mínimo no puede ser mayor que el máximo.");
        }
        return random.nextInt((max - min) + 1) + min;
    }
}
