
package monitor;

import oshi.hardware.platform.linux.LinuxCentralProcessor;


public class CpuLinux implements CPU{

    @Override
    public String getFamilia() {
        LinuxCentralProcessor p = new LinuxCentralProcessor();
        return p.getFamily();
    }

    @Override
    public String getModelo() {
        LinuxCentralProcessor p = new LinuxCentralProcessor();
        return p.getModel();
    }

    @Override
    public String getFabricante() {
        LinuxCentralProcessor p = new LinuxCentralProcessor();
        return p.getVendor();
    }

    @Override
    public Boolean esDe64Bits() {
        LinuxCentralProcessor p = new LinuxCentralProcessor();
        return p.isCpu64bit();
    }
    
}
