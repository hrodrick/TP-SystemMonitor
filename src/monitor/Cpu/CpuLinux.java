
package monitor.Cpu;

import oshi.hardware.platform.linux.LinuxCentralProcessor;


public class CpuLinux extends CentralProcessorUnit{

    public CpuLinux() {
        super(new LinuxCentralProcessor());
    }
    
}
