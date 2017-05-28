
package monitor.Cpu;

import oshi.hardware.platform.linux.LinuxCentralProcessor;


public class CpuLinux extends CPU{

    public CpuLinux() {
        super(new LinuxCentralProcessor());
    }
    
}
