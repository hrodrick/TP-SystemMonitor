package monitor.Sensores;

import java.util.ArrayList;
import monitor.JSONSerializable;
import oshi.hardware.Sensors;

public abstract class Sensores implements ISensores,
        JSONSerializable {

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
        ///Forma Chota
        /*        
        int fansSpeed[] = m.getSensores().getVelVentiladores();
            for(int i = 0; i < fansSpeed.length; i++){
                System.out.println("Velocidad ventilador "+ i +": "+ fansSpeed[i]);
            }
         */
        /*
        int fansSpeed[] = this.getVelVentiladores();
        ArrayList<String> ventiladores = new ArrayList<String>();        

        for (int i = 0; i < fansSpeed.length; i++) {
            ventiladores.add("Velocidad ventilador " + i + ": "+ fansSpeed[i]);            
        }
         */
        
        /*
        String Json = "{\"Temperatura CPU \":" + this.getTempCPU()
                + "\"Voltaje CPU \":" + this.getVoltajeCPU()
                + ventiladores.toString() + "}";
        */
        ///-------------------------------------------------
        int fansSpeed[] = this.getVelVentiladores();
        String ventilador = "\"Velocidad Ventilador\":";
        for(int i : fansSpeed ){
            ventilador += i +": " + String.valueOf(i);            
        }
        String Json = "{\"Temperatura CPU \":" + Math.round(this.getTempCPU())
                + "\"Voltaje CPU \":" + this.getVoltajeCPU()
                + ventilador + "}";

        return Json;
    }

}
