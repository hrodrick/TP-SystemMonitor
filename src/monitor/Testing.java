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
            
            System.out.println("familia: "+m.getMicro().getFamiliaCPU());
            System.out.println("modelo: "+m.getMicro().getModeloCPU());
            System.out.println("fabricante: "+m.getMicro().getFabricanteCPU());
            System.out.println("Nombre: "+m.getMicro().getNombreCPU());
            System.out.println("Nucleos: "+m.getMicro().getNucleosFisicosCPU());
            System.out.println("Hilos: "+m.getMicro().getNucleosLogicosCPU());
            //Tester de Rodrigo soria. -testeando
            //TesteandoMemoria
            System.out.println("Memoria RAM total: " + m.getMemoria().getMemFisicaTotal());
            System.out.println("Memoria RAM usada: " + m.getMemoria().getMemFisicaUso());
            System.out.println("Memoria RAM dispo: " + m.getMemoria().getMemFisicaDisponible());
            System.out.println("Memoria de intercambio total: " + m.getMemoria().getMemSwapTotal());
            System.out.println("Memoria de intercambio usada: " + m.getMemoria().getMemSwapUso());
            System.out.println("Memoria de intercambio dispo: "+ + m.getMemoria().getMemSwapDisponible());
            //TesteandoSistemaOperativo
            System.out.println("Fabricante SO: " + m.getSistemaOperativo().getFabricanteOS());
            System.out.println("Familia SO: " + m.getSistemaOperativo().getFamiliaOS());
            System.out.println("Version SO: " + m.getSistemaOperativo().getVersionOS());
            System.out.println("Edicion SO: " + m.getSistemaOperativo().getEdicionOS());
            //TesteandoSensores
            System.out.println("Temperatura CPU: " + m.getSensores().getTempCPU());
            System.out.println("Voltaje CPU: " + m.getSensores().getVoltajeCPU());
            int fansSpeed[] = m.getSensores().getVelVentiladores();
            for(int i = 0; i < fansSpeed.length; i++){
                System.out.println("Velocidad ventilador "+ i +": "+ fansSpeed[i]);
            }
            //Testeando PlacaMadre
            System.out.println("Marca Placa madre: " + m.getPlacaMadre().getMarcaMother());
            System.out.println("Modelo Placa madre: " + m.getPlacaMadre().getModeloMother());
            
            
            
        }
}
