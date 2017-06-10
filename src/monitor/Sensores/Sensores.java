package monitor.Sensores;

import org.json.JSONStringer;
import oshi.hardware.Sensors;

public abstract class Sensores implements ISensores {

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
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Temperatura").value(this.getTempCPU())
                .key("Voltaje").value(this.getVoltajeCPU())
                .key("Ventiladores").value(this.getVelVentiladores())
                .endObject().toString();

        return Json;
    }

    @Override
    public String toConsoleStringActualizable() {

        String ventiladores = "";
        int i = 0;
        for (int vel : getVelVentiladores()) {
            ventiladores = ventiladores.concat("vent. " + i + ": " + vel + "rpm" + "\n");
            i++;
        }
        String result = "Sensores: "
                + "\nTemperatura CPU: " + getTempCPU()
                + "\nVoltaje de CPU: " + getVoltajeCPU()
                + "\nVelocidad de ventiladores: "
                + "\n" + ventiladores;
        return result;
    }

}
