package monitor;

import java.util.ArrayList;
import java.util.Arrays;
import monitor.NICS.INIC;
import oshi.SystemInfo;


public class Testing {
        public static void main(String[] Args){
            
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
            default:
                System.out.println("Su sistema operativo aún no está soportado");
            }
        }
        
        private static void test(Monitor m){
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
            //NO BORRAR >:v
            ArrayList<INIC> nics = m.getNetworks().getNics();
            for(INIC controlador : nics){
                System.out.println("Nombre: " + controlador.getNombre());
                System.out.println("IPv4: " + Arrays.toString(controlador.getIPv4()));
                System.out.println("MAC: " + controlador.getMacAdress());
            }
            //Testeando NICS - Uso Json:
            for (INIC controlador : nics)
                System.out.println(controlador.toJson());
            
            
        }
}
