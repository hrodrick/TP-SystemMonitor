package monitor;


import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JFrame;
import persistencia.ArchivoJSON;
import ui.UserInterface;

public class Displayer {

    private Monitor m;
    private boolean guiIsOn;
    private int refresco; // intérvalo entre cada actualización
    private int duracion; // duracion en segundos que durará la actualización de los datos.
    private String rutaJson; //Path del archivo a escribir

    public Displayer(Monitor m) {
        this.m = m;
        guiIsOn = true;
        refresco = 500;
        duracion = 10;
        rutaJson = "C:\\datosSistema.txt";
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
        
        System.out.println(m.toString()
                + "\n--------------------------------\nO"
                + "\nDesea una sucesion de datos en tiempo real? S/N + enter"
                + "\ndurará : " + duracion + "segundos"
                + "\nse actualizará cada: " + refresco + "milisegundos.\n");
        Scanner lector = new Scanner(System.in);
        
        String option = lector.next();
        if (option.equalsIgnoreCase("s")) {
            display_ConsoleActualizable();
        }
        // escritura de archivo
        System.out.println("\nDesea crear un archivo con los datos actuales del sistema? S/N\n");
        option = lector.next();
        if (option.equalsIgnoreCase("s")) {
            display_imprimir();
        }
        // lectura de archivo
        System.out.println("\nDesea desea leer de un archivo los datos del sistema? S/N\n");
        option = lector.next();
        String clave = "";
        if (option.equalsIgnoreCase("s")) {
            ArchivoJSON datos = new ArchivoJSON();
            do{                
                System.out.println("\nEscriba la clave del valor a leer: ");
                clave = lector.next();
                System.out.println(datos.leer(clave, rutaJson));
                System.out.println("\nDesea continuar leyendo datos? S/N\n");
                option = lector.next();
            }while(option.equalsIgnoreCase("s"));
        }
        
    }

    private void display_ConsoleActualizable() throws InterruptedException {
        int a;
        DecimalFormat df = new DecimalFormat();
        //multiplico duracion * 1000 para que refresco simule ser milisegundos.
        for (int i = 0; i < duracion * 1000; i += refresco) {
            a = 0;
            String ventiladores = "";
            
            for (int vel : m.getSensores().getVelVentiladores()) {
                ventiladores = ventiladores.concat("vent. " + a + ": " + vel + "rpm" + "\n");
                a++;
            }
            System.out.println("\n--------------------------------"
                    + "\nUso CPU:" + df.format(100 * m.getMicro().getUsoActualCPU()) + "%"
                    + "\nTemperatura CPU: " + m.getSensores().getTempCPU() + "ºC"
                    + "\nVoltaje de CPU: " + df.format(100 * m.getSensores().getVoltajeCPU()) + "W"
                    + "\nVelocidad de ventilador: "
                    + ventiladores
                    + "\nRAM en uso: " + m.getMemoria().getMemFisicaUso()
                    + "\nRAM disponible: " + m.getMemoria().getMemFisicaDisponible()
                    + "\nSwap en uso: " + m.getMemoria().getMemSwapUso()
                    + "\nSwap diponible: " + m.getMemoria().getMemSwapDisponible()
                    + "NICS:" + m.getNetworks().toString());
            Thread.sleep(refresco);
        }
    }

    private void display_imprimir() {
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
            Thread.sleep(gui.getFrecuenciaActualizacion() * 30); //Hasta 3 segundos de retardo
        }
    }

    private UserInterface construirGUI() {
        UserInterface UI = new UserInterface(m);
        UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.setSize(1024, 600);
        return UI;
    }

}
