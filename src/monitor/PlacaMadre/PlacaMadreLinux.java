/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.PlacaMadre;

import oshi.hardware.platform.linux.LinuxHardwareAbstractionLayer;

/**
 *
 * @author Rodrigo Soria
 */
public class PlacaMadreLinux extends PlacaMadre {
    
    public PlacaMadreLinux() {
        super(new LinuxHardwareAbstractionLayer().getComputerSystem());
    }
    
}
