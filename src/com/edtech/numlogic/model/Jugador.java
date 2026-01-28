package com.edtech.numlogic.model;

/**
 * Represents a player in NumLogic Explorer.
 * Adheres to Clean Code: Descriptive naming and single responsibility.
 */
public class Jugador {
    private String nombre;
    private int edad;
    private String curso;
    private int mejorPuntaje; // Number of attempts in the best game

    public Jugador(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
        this.mejorPuntaje = Integer.MAX_VALUE; // Initialize with a high value
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurso() {
        return curso;
    }

    public int getMejorPuntaje() {
        return mejorPuntaje;
    }

    public void setMejorPuntaje(int mejorPuntaje) {
        if (mejorPuntaje < this.mejorPuntaje) {
            this.mejorPuntaje = mejorPuntaje;
        }
    }
}
