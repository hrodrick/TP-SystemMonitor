/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.PlacaMadre;

import oshi.hardware.platform.windows.WindowsHardwareAbstractionLayer;

/**
 *
 * @author Rodrigo Soria
 */
public class PlacaMadreWindows extends PlacaMadre {
    
    public PlacaMadreWindows() {
        super(new WindowsHardwareAbstractionLayer().getComputerSystem());
    }
    
}
