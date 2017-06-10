package monitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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
        // Y se creará un displayer concreto para este monitor.
        m = monitorSelection();
        Displayer display = new Displayer(m);
        
        // Si no hay monitor para su sistema operativo el programa 
        // debería finalizar sin ningún problema.
        if (m != null) {
            display.displaySelection(guiIsOn);
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


}
