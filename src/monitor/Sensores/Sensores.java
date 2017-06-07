package monitor.Sensores;


import org.json.JSONStringer;
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
        /*Forma chota y vieja
        int fansSpeed[] = this.getVelVentiladores();
        String ventilador = "\"Velocidad Ventilador\":["+"";
        for(int i : fansSpeed ){            
            ventilador += i+", " + String.valueOf(i);           
        }
            ventilador+="]";
        String Json = "{\"Temperatura CPU \":\""+Math.round(this.getTempCPU())+"\","
                + "\"Voltaje CPU \":\""+this.getVoltajeCPU()+"\","
                + ventilador + "}";
        */
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Temperatura").value(this.getTempCPU())
                .key("Voltaje").value(this.getVoltajeCPU())
                .key("Ventiladores").value(this.getVelVentiladores())
                .endObject().toString();
        
        return Json;
    }

}


