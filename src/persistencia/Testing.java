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

/**
 *
 * @author dell
 */
public class Testing {
    
    public static void main(String args[]) throws IOException{
    ///Practica de escritura en el archivo o algo asi
        JSONObject obj = new JSONObject();
        Monitor m = new MonitorWindows();
        
        
        obj.put("CPU", m.getMicro().toJson());
        obj.put("Memorias", m.getMemoria().toJson());
        obj.put("Placa Madre", m.getPlacaMadre().toJson());
        obj.put("SO", m.getSistemaOperativo().toJson());
        obj.put("Sensores", m.getSensores().toJson());       
        
        ArchivoJSON archivo = new ArchivoJSON();
        archivo.escribir(obj.toString());
        
        System.out.print(obj);
        ///---------------------------------------------------
    }
    
    
}
