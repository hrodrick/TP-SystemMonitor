/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author Alumno
 */
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
            
        }
}
