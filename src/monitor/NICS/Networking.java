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
public abstract class Networking implements INetworking{
    
    private AbstractNetworks networks;
    private ArrayList<NIC> nics;
    
    public Networking(AbstractNetworks nets){
        networks = nets;
        nics = new ArrayList<>();
        establecerNics();
    }
    
    @Override
    public ArrayList<NIC> getNics() {
        return nics;
    }
    
    private void establecerNics(){
        for(NetworkIF NIFcontroller : networks.getNetworks()){
            nics.add(new NIC(NIFcontroller));
        }   
    }
    
}