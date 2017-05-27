
package monitor;

import monitor.Cpu.CpuWindows;
import monitor.Memoria.MemoriaWindows;


public class MonitorWindows extends Monitor {
    static CpuWindows micro;
    static MemoriaWindows memoria;
    
    static{  
        micro = new CpuWindows(); 
        memoria = new MemoriaWindows();
    }
    
    
    public MonitorWindows() {
        super(MonitorWindows.micro, MonitorWindows.memoria);
    }
}
