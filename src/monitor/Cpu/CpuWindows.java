
package monitor.Cpu;
import oshi.hardware.platform.windows.WindowsCentralProcessor;


public class CpuWindows extends CPU{
    
    public CpuWindows() {
        super(new WindowsCentralProcessor());
    }
    
}
