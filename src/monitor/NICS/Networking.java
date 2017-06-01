/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.NICS;


import java.util.ArrayList;
import oshi.hardware.NetworkIF;
import oshi.hardware.common.AbstractNetworks;

/**
 *
 * @author Rodrigo Soria
 */
public class Networking implements INetworking{
    
    AbstractNetworks networks;
    
    public Networking(AbstractNetworks nets){
        networks = nets;
    }
    
    @Override
    public ArrayList<NIC> getNics() {
        NetworkIF nets[] = networks.getNetworks();
        ArrayList<NIC> nics = new ArrayList<>();
        for(NetworkIF NIFcontroller : nets){
            nics.add(new NIC(NIFcontroller));
        }
        
        return nics;
    }
    
}
