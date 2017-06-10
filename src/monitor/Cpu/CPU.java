package monitor.Cpu;

import org.json.JSONStringer;
import oshi.hardware.CentralProcessor;

public abstract class CPU implements ICPU {

    private CentralProcessor p;

    public CPU(CentralProcessor p) {
        this.p = p;
    }

    @Override
    public String getFamiliaCPU() {
        return p.getFamily();
    }

    @Override
    public String getModeloCPU() {

        return p.getModel();
    }

    @Override
    public String getFabricanteCPU() {

        return p.getVendor();
    }

    @Override
    public Boolean esDe64Bits() {

        return p.isCpu64bit();
    }

    @Override
    public int getNucleosLogicosCPU() {

        return p.getLogicalProcessorCount();
    }

    @Override
    public int getNucleosFisicosCPU() {

        return p.getPhysicalProcessorCount();
    }

    @Override
    public String getNombreCPU() {

        return p.getName();
    }

    @Override
    public double getUsoActualCPU() {
        return p.getSystemCpuLoad();
    }

    @Override
    public String toJson() {
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Fabricante").value(this.getFabricanteCPU())
                .key("Familia").value(this.getFamiliaCPU())
                .key("Modelo").value(this.getModeloCPU())
                .key("Nombre").value(this.getNombreCPU())
                .key("Nucleos fisicos").value(this.getNucleosFisicosCPU())
                .key("Nucleos logicos").value(this.getNucleosLogicosCPU())
                .key("Uso actual").value(this.getUsoActualCPU())
                .endObject().toString();
        return Json;
    }

    @Override
    public String toConsoleString() {
        String result = "Procesador: "
                + "\n" + getNombreCPU()
                + "\nFabricante: " + getFabricanteCPU()
                + "\nFamilia: " + getFamiliaCPU()
                + "\nModelo: " + getModeloCPU()
                + "\nNucleos: " + getNucleosFisicosCPU()
                + "\nHilos: " + getNucleosLogicosCPU()
                + "\nArquitectura: " + (esDe64Bits() ? "x64" : "x86");

        return result;
    }

    @Override
    public String toConsoleStringActualizable() {
        String result = "Uso de CPU: " + getUsoActualCPU();
        return result;
    }

}
