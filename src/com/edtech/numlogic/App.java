package com.edtech.numlogic;

import com.edtech.numlogic.controller.ControladorJuego;
import com.edtech.numlogic.view.InterfazUsuario;

/**
 * Entry point for NumLogic Explorer.
 */
public class App {
    public static void main(String[] args) {
        InterfazUsuario vista = new InterfazUsuario();
        ControladorJuego controlador = new ControladorJuego(vista);
        controlador.iniciar();
    }
}
