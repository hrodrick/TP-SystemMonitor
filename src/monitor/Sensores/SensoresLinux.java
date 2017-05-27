/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Sensores;

import oshi.hardware.platform.linux.LinuxSensors;



/**
 *
 * @author Rodrigo Soria
 */
public class SensoresLinux extends Sensores {

    public SensoresLinux() {
        super(new LinuxSensors());
    }
    
}
