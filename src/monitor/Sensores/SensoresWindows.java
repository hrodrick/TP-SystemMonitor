/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Sensores;

import oshi.hardware.platform.windows.WindowsSensors;

/**
 *
 * @author Rodrigo Soria
 */
public class SensoresWindows extends Sensores {

    public SensoresWindows() {
        super(new WindowsSensors());
    }
    
}
