package com.edtech.numlogic.model;

import java.util.Random;

/**
 * Handles random number generation.
 * Separated for testability (Single Responsibility Principle).
 */
public class GeneradorAleatorio {
    private final Random random;

    public GeneradorAleatorio() {
        this.random = new Random();
    }

    /**
     * Generates a random number within [min, max].
     */
    public int generarNumero(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min cannot be greater than Max");
        }
        return random.nextInt((max - min) + 1) + min;
    }
}
