/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.NICS;

import oshi.hardware.platform.linux.LinuxNetworks;

/**
 *
 * @author Rodrigo Soria
 */
public class NetworkingLinux extends Networking{
    public NetworkingLinux(){
        super(new LinuxNetworks());
    }
}
