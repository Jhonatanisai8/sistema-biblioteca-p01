package Controlador;

import Modelo.Biblioteca;
import Vista.frmInicioSesion;
import Vista.frmMenu;

public class Principal {
    
    public static Biblioteca BIBLIOTECA;
    
    public static void main(String[] args) {
        BIBLIOTECA = new Biblioteca("LEA PARA VIVIR");
        frmInicioSesion inicioSesion = new frmInicioSesion();
        inicioSesion.setTitle("INICIO DE SESIÓN");
        inicioSesion.setVisible(true);
    }
    
}
