/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.NICS;

import java.util.Arrays;
import org.json.JSONStringer;
import oshi.hardware.NetworkIF;

/**
 *
 * @author Rodrigo Soria
 */
public class NIC implements INIC{
    
    private NetworkIF controladorRed; 
    
    public NIC(NetworkIF controller){
        controladorRed = controller;
    }
    @Override
    public String[] getIPv4(){
        return controladorRed.getIPv4addr();
    }
    @Override
    public String getMacAdress(){
        return controladorRed.getMacaddr();
    }
    @Override
    public String getNombre(){
        return controladorRed.getName();
    }

    @Override
    public String toJson() {         
        
        /*Forma Vieja y chota
        String IPs[] = this.getIPv4();
        String IPv4 = "\"IPv4\":\"" ;
        for(int i=0;i<IPs.length;i++){
            //if(i!=IPs.length)
            IPv4 += i+", " + IPs[i];
            //else
            //IPv4 += i+ IPs[i];           
        }   
        
        String Json = "{\"Nombre\":\"" +this.getNombre()+"\","                
                + "\"MAC\":\"" +this.getMacAdress()+"\","
                + IPv4 +"\"}";
        */        
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Nombre").value(this.getNombre())
                .key("IPv4").value(this.getIPv4())
                .key("MAC").value(this.getMacAdress())
                .endObject().toString();
        
        
        
        return Json;
    }
    
    
    
}
