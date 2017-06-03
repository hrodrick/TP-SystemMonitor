/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.NICS;

import oshi.hardware.NetworkIF;

/**
 *
 * @author Portatil
 */
public class NicWindows extends NIC{
    
    public NicWindows(NetworkIF nic){
        super(nic);
    }
}
