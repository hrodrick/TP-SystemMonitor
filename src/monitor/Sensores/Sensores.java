/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Sensores;

import java.util.ArrayList;
import monitor.JSONSerializable;
import oshi.hardware.Sensors;
/**
 *
 * @author Rodrigo Soria
 */
public abstract class Sensores implements ISensores,
                                JSONSerializable{
    
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
    @Override
    public String toJson() {
        /*
        this.get
        int fansSpeed[] = m.getSensores().getVelVentiladores();
            for(int i = 0; i < fansSpeed.length; i++){
                System.out.println("Velocidad ventilador "+ i +": "+ fansSpeed[i]);
            }
        */
            
        String Json = "{\"Temperatura CPU \":" + this.getTempCPU()
                + "\"Voltaje CPU \":" + this.getVoltajeCPU()+"}";
        
        return Json;
    }
    
}
