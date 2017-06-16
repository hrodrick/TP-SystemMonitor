package persistencia;
import java.io.IOException;
import monitor.Monitor;
import monitor.MonitorWindows;

public class Testing {
    
    public static void main(String args[]) throws IOException{
    ///Practica de escritura en el archivo o algo asi
    ///Libreria loca JSON tiene JSONStringer() fijarse esta funcion        
        Monitor m = new MonitorWindows();                
        ArchivoJSON archivo = new ArchivoJSON();        
        archivo.escribir(m.toJson(),"c:/prueba.txt");
        System.out.println(archivo.leer("Procesador", "c:/prueba.txt"));     
        ///---------------------------------------------------
    }
    
    
}