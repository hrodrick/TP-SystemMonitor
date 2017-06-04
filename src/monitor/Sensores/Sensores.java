package monitor.Sensores;


import oshi.hardware.Sensors;

public abstract class Sensores implements ISensores{

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
