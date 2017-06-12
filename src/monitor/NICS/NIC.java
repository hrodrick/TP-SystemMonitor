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
    public long getBytesEnviados(){
        controladorRed.updateNetworkStats();
        return controladorRed.getBytesSent();
    }
    @Override
    public long getBytesRecibidos(){
        controladorRed.updateNetworkStats();
        return controladorRed.getBytesRecv();
    }

    @Override
    public String toJson() {         
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Nombre").value(this.getNombre())
                .key("IPv4").value(this.getIPv4())
                .key("MAC").value(this.getMacAdress())
                .key("BytesEnviados").value(this.getBytesEnviados())
                .key("BytesRecibidos").value(this.getBytesRecibidos())
                .endObject().toString();
        
        return Json;
    }

    @Override
    public String toConsoleString() {
        String result = "Nombre: " + getNombre()+
                        "\nIPv4: " + Arrays.toString(getIPv4())+
                        "\nMAC: " + getMacAdress()+
                        "\n-----";
        return result;
    }
    @Override
    public String toConsoleStringActualizable(){
        String result = "\nBytes enviados: " + getBytesEnviados()+
                        "\nBytes recibidos: " + getBytesRecibidos()+
                        "\n-----";
        return result;
    }
    
    
}
