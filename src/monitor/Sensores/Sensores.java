/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Sensores;

import java.util.ArrayList;
import oshi.hardware.Sensors;
/**
 *
 * @author Rodrigo Soria
 */
public class Sensores implements ISensores{
    
    private Sensors sensores; 
    
    
    public Sensores(Sensors sensores) {
        this.sensores = sensores;
    }
    
    @Override
    public Double getTempCPU() {
       return sensores.getCpuTemperature();
    }

    @Override
    public Double getVoltajeCPU() {
        return sensores.getCpuVoltage();
    }

    @Override
    public int[] getVelVentiladores() {
        
        return sensores.getFanSpeeds();
    }
    
}
