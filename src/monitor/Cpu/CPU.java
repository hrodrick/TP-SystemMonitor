package monitor.Cpu;


import oshi.hardware.CentralProcessor;

public abstract class CPU implements ICPU{

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
        
        String Json = "{\"Familia \":" + this.getFamiliaCPU()
                + "\"Modelo \":" + this.getModeloCPU()
                + "\"Fabricante \":" + this.getFabricanteCPU()
                + "\"Nombre \":" + this.getNombreCPU()
                + "\"Nucleos \":" + this.getNucleosFisicosCPU()
                + "\"Uso actual \":" + this.getUsoActualCPU()
                + "\"Hilos \":" + this.getNucleosLogicosCPU()+"}";
        
        return Json;
    }

}
