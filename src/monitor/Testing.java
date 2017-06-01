package monitor;

import java.util.ArrayList;
import java.util.Arrays;
import monitor.NICS.NIC;


public class Testing {
        public static void main(String[] Args){
            Monitor m = new MonitorWindows();            
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
            ArrayList<NIC> nics = m.getNetworks().getNics();
            for(NIC controlador : nics){
                System.out.println("Nombre: " + controlador.getNombre());
                System.out.println("IPv4: " + Arrays.toString(controlador.getIPv4()));
                System.out.println("MAC: " + controlador.getMacAdress());
            }
            //Testeando NICS Json:
            for (NIC controlador : nics)
                System.out.println(controlador.toJson());
            
        }
}
