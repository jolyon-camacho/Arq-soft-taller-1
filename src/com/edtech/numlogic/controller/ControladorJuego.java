package com.edtech.numlogic.controller;

import com.edtech.numlogic.model.Configuracion;
import com.edtech.numlogic.model.GeneradorAleatorio;
import com.edtech.numlogic.model.Juego;
import com.edtech.numlogic.model.Jugador;
import com.edtech.numlogic.view.InterfazUsuario;

/**
 * Orchestrates the flow of NumLogic Explorer.
 * Connects the Model and the View.
 */
public class ControladorJuego {
    private final InterfazUsuario vista;
    private final Configuracion configuracion;
    private final GeneradorAleatorio generador;
    private Jugador jugador;

    public ControladorJuego(InterfazUsuario vista) {
        this.vista = vista;
        this.configuracion = new Configuracion();
        this.generador = new GeneradorAleatorio();
    }

    public void iniciar() {
        vista.mostrarBienvenida();
        registrarJugador();

        boolean continuar = true;
        while (continuar) {
            configurarDificultad();
            jugarPartida();
            continuar = vista.preguntarReintento();
        }

        vista.mostrarMensaje("¡Gracias por jugar, " + jugador.getNombre() + "! Hasta la próxima.");
    }

    private void registrarJugador() {
        String nombre = vista.capturarTexto("Introduce tu nombre");
        int edad = vista.capturarEntero("Introduce tu edad");
        String curso = vista.capturarTexto("Introduce tu curso/grado");

        this.jugador = new Jugador(nombre, edad, curso);
    }

    private void configurarDificultad() {
        vista.mostrarMensaje("Selecciona la dificultad:");
        vista.mostrarMensaje("1. Principiante (Rango 1-10)");
        vista.mostrarMensaje("2. Avanzado (Rango 1-1000)");

        int nivel = vista.capturarEntero("Opción");
        if (nivel != Configuracion.PRINCIPIANTE && nivel != Configuracion.AVANZADO) {
            vista.mostrarMensaje("Opción no válida. Se asignará nivel Principiante por defecto.");
            nivel = Configuracion.PRINCIPIANTE;
        }

        configuracion.establecerDificultad(nivel);
    }

    private void jugarPartida() {
        Juego partida = new Juego(configuracion, generador);
        partida.iniciarPartida();

        vista.mostrarMensaje("He pensado un número entre " +
                configuracion.getRangoMinimo() + " y " + configuracion.getRangoMaximo() + ". ¡Adivínalo!");

        while (partida.isJuegoActivo()) {
            int intento = vista.capturarEntero("Tu número");
            int resultado = partida.validarIntento(intento);

            if (resultado == 0) {
                vista.mostrarResultadoFinal(
                        partida.getIntentosRealizados(),
                        partida.getTiempoTranscurrido(),
                        partida.getNumeroSecreto());
                jugador.setMejorPuntaje(partida.getIntentosRealizados());
            } else {
                vista.mostrarPista(resultado > 0);
            }
        }
    }
}
