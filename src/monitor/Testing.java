package monitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import monitor.NICS.INIC;
import oshi.SystemInfo;
import persistencia.ArchivoJSON;
import ui.UserInterface;

public class Testing {

    public static void main(String[] args) throws InterruptedException {
        boolean guiIsOn = false;
        Monitor m;

        // En el Hashmap guardare la información de los parámetros de 
        // ejecución del programa.
        HashMap<String, String> argumentos = argumentsSet(args);

        // si deseo ver la interfaz gráfica guiON sera true y será enviado a 
        // "displaySelection" para que la gui se active.
        if (argumentos.containsKey("gui")) {
            if (argumentos.get("gui").equalsIgnoreCase("true")) {
                guiIsOn = true;
            }
        }

        // Se seleccionará el monitor correspondiente al Sistema operativo.
        m = monitorSelection();

        // Si no hay monitor para su sistema operativo el programa 
        // debería finalizar sin ningún problema.
        if (m != null) {
            displaySelection(m, guiIsOn);
        }

    }

    private static HashMap<String, String> argumentsSet(String[] args) {
        HashMap<String, String> argumentos = new HashMap<>();
        for (String a : args) {
            String[] argumentosDeEntrada = a.split("="); //Divido el string en el '='
            argumentos.put(argumentosDeEntrada[0], argumentosDeEntrada[1]); //Pongo clave y valor en el Hashmap
        }
        return argumentos;
    }

    private static Monitor monitorSelection() {
        Monitor m = null;

        switch (SystemInfo.getCurrentPlatformEnum()) {
            //Armo los casos para cada sistema. y los muestro por pantalla.
            case LINUX:
                System.out.println("Usted tiene Linux instalado");
                m = new MonitorWindows();
                break;
            case WINDOWS:
                System.out.println("Usted tiene Windows instalado");
                m = new MonitorWindows();
                break;
            default:
                System.out.println("Su sistema operativo aún no está soportado");

        }
        return m;
    }

    private static void displaySelection(Monitor m, boolean guiIsOn) throws InterruptedException {
        if (guiIsOn) {
            display_graphic(m);
        } else {
            display_console(m);
        }
    }

    private static void JsonTest(Monitor m) {
        System.out.println(m.getMicro().toJson());
        //Tester de Rodrigo soria. -testeando modificado por Mischuk por los JSON
        //TesteandoMemoria
        System.out.println(m.getMemoria().toJson());
        //TesteandoSistemaOperativo
        System.out.println(m.getSistemaOperativo().toJson());
        //TesteandoSensores
        System.out.println(m.getSensores().toJson());
        //Testeando PlacaMadre
        System.out.println(m.getPlacaMadre().toJson());
        //Testeando NICS - Uso basico-practico            
        ArrayList<INIC> nics = m.getNetworks().getNics();
        /*
            for(INIC controlador : nics){
                System.out.println("Nombre: " + controlador.getNombre());
                System.out.println("IPv4: " + Arrays.toString(controlador.getIPv4()));
                System.out.println("MAC: " + controlador.getMacAdress());
            }
         */
        //Testeando NICS - Uso Json:
        for (INIC controlador : nics) {
            System.out.println(controlador.toJson());
        }
        //Testeando Monitor.toJson
        //System.out.println(m.toJson());
    }

    private static void display_console(Monitor m) throws InterruptedException {
        System.out.println(m.toConsoleString()
                + "\n\no--------------------------------o\n"
                + "Desea una sucesion de datos en tiempo real? S/N + enter (Se mostraran 10 lecturas a 2 seg. cada una)\n");
        Scanner lector = new Scanner(System.in);
        String option = lector.next();
        if (option.equalsIgnoreCase("s")) {
            display_ConsoleActualizable(m);
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

    private static void display_ConsoleActualizable(Monitor m) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(m.toConsoleStringActualizable());
            Thread.sleep(2000);
            i++;
        }
    }

    private static void display_graphic(Monitor m) throws InterruptedException {
        UserInterface gui = construirGUI(m);
        gui.setVisible(true);

        while (true) {
            //Actualiza los datos constantemente.
            gui.actualizarDatosSensorYCarga();

            // pone el poner el hilo actual en pausa
            // por el tiempo que se necesite en milisegundos
            Thread.sleep(gui.getFrecuenciaActualizacion() * 20); //Hasta 2 segundos de retardo
        }
    }

    private static UserInterface construirGUI(Monitor monitor) {
        UserInterface UI = new UserInterface(monitor);
        UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.setSize(1024, 600);
        return UI;
    }

}
