package monitor;
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
