/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.NICS;

import java.util.Arrays;
import monitor.JSONSerializable;
import oshi.hardware.NetworkIF;

/**
 *
 * @author Rodrigo Soria
 */
public class NIC implements INIC,
                            JSONSerializable{
    
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
        String Json = "{\"Nombre \":" + this.getNombre()
                + "\"IPv4 \":" + Arrays.toString(this.getIPv4())
                + "\"MAC \":" + this.getMacAdress()+"}";
        
        return Json;
    }
    
    
    
}
