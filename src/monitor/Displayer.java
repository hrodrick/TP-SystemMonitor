/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import persistencia.ArchivoJSON;
import ui.UserInterface;

/**
 *
 * @author Rodrigo Soria
 */
public class Displayer {

    private Monitor m;
    private boolean guiIsOn;
    private int refresco; // intérvalo entre cada actualización
    private int duracion; // duracion en segundos que durará la actualización de los datos.
    private String rutaJson; //Path del archivo a escribir

    public Displayer(Monitor m) {
        this.m = m;
        this.guiIsOn = true;
        refresco = 500;
        duracion = 10;
        rutaJson = "C:\\datosSistema.JSON";
    }

    public void setGuiIsOn(boolean isOn) {
        guiIsOn = isOn;
    }

    public void setRefresco(int refresco) {
        this.refresco = refresco;
    }

    public void setduracion(int duracion) {
        this.duracion = duracion;
    }

    public void setDirectorio(String dir) {
        this.rutaJson = dir;
    }

    public void displaySelection() throws InterruptedException {
        if (guiIsOn) {
            display_graphic();
        } else {
            display_console();
        }
    }

    private void display_console() throws InterruptedException {
        display_imprimir();
        System.out.println(m.toConsoleString()
                + m.toConsoleStringActualizable()
                + "\n--------------------------------o\n"
                + "Desea una sucesion de datos en tiempo real? S/N + enter\n");
        
        Scanner lector = new Scanner(System.in);
        String option = lector.next();
        if (option.equalsIgnoreCase("s")) {
            display_ConsoleActualizable();
        }

    }

    private void display_ConsoleActualizable() throws InterruptedException {
        
        for (int i = 0; i < duracion*1000; i += refresco) {
            System.out.println(m.toConsoleStringActualizable());
            Thread.sleep(refresco);
        }
    }

    private void display_imprimir(){
        ArchivoJSON archi = new ArchivoJSON();
        archi.escribir(m.toJson(), rutaJson);
    }
    
    private void display_graphic() throws InterruptedException {
        UserInterface gui = construirGUI();
        gui.setVisible(true);

        while (true) {
            //Actualiza los datos constantemente.
            gui.actualizarDatosSensorYCarga();

            // pone el hilo actual en pausa
            // por el tiempo que se necesite en milisegundos
            Thread.sleep(gui.getFrecuenciaActualizacion() * 20); //Hasta 2 segundos de retardo
        }
    }

    private UserInterface construirGUI() {
        UserInterface UI = new UserInterface(m);
        UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.setSize(1024, 600);
        return UI;
    }

}
