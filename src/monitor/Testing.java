package monitor;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import monitor.NICS.INIC;
import oshi.SystemInfo;
import ui.UserInterface;


public class Testing {
        public static void main(String[] Args) throws InterruptedException{
            
            switch (SystemInfo.getCurrentPlatformEnum()) {
            //Armo los casos para cada OS
            case LINUX:
                System.out.println("Usted tiene Linux instalado");
                Monitor mL = new MonitorWindows();
                test(mL);
                break;
            case WINDOWS:
                System.out.println("Usted tiene Windows instalado");
                Monitor mW = new MonitorWindows();   
                test(mW);
                break;
            default:
                System.out.println("Su sistema operativo aún no está soportado");
            }
        }
        
        private static void test(Monitor m) throws InterruptedException{
            
            //Testeando interfaz
            UserInterface gui = construirGUI(m);
            gui.setVisible(true);
            
            while (true) {
                //Actualiza los datos constantemente.
                gui.actualizarDatosSensorYCarga();
                
                // pone el poner el hilo actual en pausa
                // por el tiempo que se necesite en milisegundos
                Thread.sleep(gui.getFrecuenciaActualizacion()*10); //Hasta 1 segundo de retardo
            }
            
            /*
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
            for(INIC controlador : nics){
                System.out.println("Nombre: " + controlador.getNombre());
                System.out.println("IPv4: " + Arrays.toString(controlador.getIPv4()));
                System.out.println("MAC: " + controlador.getMacAdress());
            }
            //Testeando NICS - Uso Json:
            for (INIC controlador : nics)
                System.out.println(controlador.toJson());
            */
            //Testeando Monitor.toJson
            //System.out.println(m.toJson());
            
            
        }
        
        
    private static UserInterface construirGUI(Monitor monitor) {
        UserInterface UI = new UserInterface(monitor);
        UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.setSize(1024, 600);
        return UI;
    }
        
}
