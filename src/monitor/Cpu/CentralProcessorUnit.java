package monitor.Cpu;
import oshi.hardware.CentralProcessor;



public abstract class CentralProcessorUnit implements CPU{
    CentralProcessor p;
    
    public CentralProcessorUnit(CentralProcessor p) {
        this.p = p;
    }

    @Override
    public String getFamilia() {
        return p.getFamily();
    }


    @Override
    public String getModelo() {
    
        return p.getModel();
    }


    @Override
    public String getFabricante() {
        
        return p.getVendor();
    }


    @Override
    public Boolean esDe64Bits() {
        
        return p.isCpu64bit();
    }
    

    @Override
    public int getNucleosLogicos() {
        
        return p.getLogicalProcessorCount();
    }
    

    @Override
    public int getNucleosFisicos() {
        
        return p.getPhysicalProcessorCount();
    }
    

    @Override
    public String getNombre() {
        
        return p.getName();
    }
    
}