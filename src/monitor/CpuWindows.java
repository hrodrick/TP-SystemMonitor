
package monitor;
import oshi.hardware.platform.windows.WindowsCentralProcessor;


public class CpuWindows implements CPU{

    @Override
    public String getFamilia() {
        WindowsCentralProcessor p = new WindowsCentralProcessor();
        return p.getFamily();
    }

    @Override
    public String getModelo() {
        WindowsCentralProcessor p = new WindowsCentralProcessor();
        return p.getModel();
    }

    @Override
    public String getFabricante() {
        WindowsCentralProcessor p = new WindowsCentralProcessor();
        return p.getVendor();
    }

    @Override
    public Boolean esDe64Bits() {
        WindowsCentralProcessor p = new WindowsCentralProcessor();
        return p.isCpu64bit();
    }
    
}
