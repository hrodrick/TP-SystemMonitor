package monitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JFrame;
import monitor.NICS.INIC;
import oshi.SystemInfo;
import ui.UserInterface;

public class Testing {

    public static void main(String[] args) throws InterruptedException {        
        boolean guiON = false;
        Monitor m = null;
        
        //En el Hashmap guardare la información de los parámetros de ejecución del programa.
        HashMap<String, String> argumentos = new HashMap<>();
        for(String a : args){
            String[] argumentosDeEntrada = a.split("="); //Divido el string en el '='
            argumentos.put(argumentosDeEntrada[0], argumentosDeEntrada[1]); //Pongo clave y valor en el Hashmap
        }
        
        //si deseo ver la interfaz gráfica guiON sera true y será enviado a "displaySelection" para que la gui se active.
        if(argumentos.containsKey("gui"))
            if(argumentos.get("gui").equalsIgnoreCase("true"))
                guiON = true;
        
        switch (SystemInfo.getCurrentPlatformEnum()) {
            //Armo los casos para cada OS
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
        
        //Si no hay monitor para su sistema operativo el programa finalizará sin ningún problema.
        if(m != null){
            //dejo la seleccion del display en una funcion aparte.
            displaySelection(m, guiON);
        }
    }
    
    
    private static void displaySelection(Monitor m, boolean guiIsOn) throws InterruptedException{
        if(guiIsOn)
            display_graphic(m);
        else
            display_console(m);
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

    private static void display_console(Monitor m) {
        System.out.println(m.toConsoleString());
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
