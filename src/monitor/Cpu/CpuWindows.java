
package monitor.Cpu;
import oshi.hardware.platform.windows.WindowsCentralProcessor;


public class CpuWindows extends CentralProcessorUnit{
    
    public CpuWindows() {
        super(new WindowsCentralProcessor());
    }
    
}
