/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.IOException;
import monitor.Monitor;
import monitor.MonitorWindows;
import org.json.JSONObject;

public class Testing {
    
    public static void main(String args[]) throws IOException{
    ///Practica de escritura en el archivo o algo asi
    ///Libreria loca JSON tiene JSONStringer() fijarse esta funcion        
        Monitor m = new MonitorWindows();        
        
        ArchivoJSON archivo = new ArchivoJSON();
        
        archivo.escribir(m.toJson(),"c:/prueba.txt");        
        archivo.leer("Procesador", "c:/prueba.txt");
        
       // System.out.print(obj);
        ///---------------------------------------------------
    }
    
    
}
