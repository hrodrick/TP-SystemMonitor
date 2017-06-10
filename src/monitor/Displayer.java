/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import persistencia.ArchivoJSON;
import ui.UserInterface;

/**
 *
 * @author Rodrigo Soria
 */
public class Displayer {
    
    Monitor m;
    
    public Displayer(Monitor m){
        this.m = m;
    }
    
    public void displaySelection(boolean guiIsOn) throws InterruptedException {
        if (guiIsOn) {
            display_graphic();
        } else {
            display_console();
        }
    }
    
    private void display_console() throws InterruptedException {
        System.out.println(m.toConsoleString()
                + "\n--------------------------------o\n"
                + "Desea una sucesion de datos en tiempo real? S/N + enter (Se mostraran 10 lecturas a 2 seg. cada una)\n");
        Scanner lector = new Scanner(System.in);
        String option = lector.next();
        if (option.equalsIgnoreCase("s")) {
            display_ConsoleActualizable();
        }
        
        System.out.println("Desea exportar la información del sistema actual a un archivo de texto?. S/N + enter");
        option = lector.next();
        
        if (option.equalsIgnoreCase("s")) {
            //Abro el archivo y lo uso dentro de un try-catch para informar sobre una posible excepción por consola.
            ArchivoJSON archi = new ArchivoJSON();
            try {
                archi.escribir(m.toJson()); //TODO: Test this.
                System.out.println("Archivo guardado."); //Si la operación falló este texto no debería mostrarte.
            } catch (IOException ex) {
                System.err.println("Operación de entrada/salida del archivo interrumpida o incorrecta.");
            }
        }
        
    }

    private void display_ConsoleActualizable() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(m.toConsoleStringActualizable());
            Thread.sleep(2000);
            i++;
        }
    }

    private void display_graphic() throws InterruptedException {
        UserInterface gui = construirGUI();
        gui.setVisible(true);

        while (true) {
            //Actualiza los datos constantemente.
            gui.actualizarDatosSensorYCarga();

            // pone el poner el hilo actual en pausa
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
