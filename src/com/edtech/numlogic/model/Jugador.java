package com.edtech.numlogic.model;

/**
 * Represents a player in NumLogic Explorer.
 * This class stores the personal data of the child playing and keeps track of
 * their
 * individual performance metrics such as personal best score.
 */
public class Jugador {
    private String nombre;
    private int edad;
    private String curso;
    private int mejorPuntaje; // Number of attempts in the best game

    /**
     * Initializes a new player with technical metadata.
     * 
     * @param nombre The name of the child.
     * @param edad   The age of the child.
     * @param curso  The current grade or course.
     */
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
