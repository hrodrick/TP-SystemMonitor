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
        /* 1* posible solucion para temperatura de CPU.
         * no parece funcionar, además en los mismos comentarios advierte de que funciona como deberia y que NO se actualiza
         * la informacion.
         * https://github.com/profesorfalken/jHardware/blob/master/src/main/java/org/jutils/jhardware/util/TemperatureUtils.java
         * 2* posibles soluciones
         * https://stackoverflow.com/questions/123575/how-to-get-the-temperature-of-motherboard-of-a-pc-and-other-hardware-statistics
         * 3* posible solucion:
         * Genera el código WMI del hardware especifíco en el que se ejecuta necesario para realizar funciones como la
         * recolección de datos de temperatura. Una lástima que no sea en java.
         * https://www.microsoft.com/en-us/download/details.aspx?id=8572
        */
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
    public String toString() {

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
