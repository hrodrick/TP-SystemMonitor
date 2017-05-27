
package monitor;

import monitor.Cpu.CpuWindows;
import monitor.Memoria.MemoriaWindows;
import monitor.SistemaOperativo.WindowsOS;


public class MonitorWindows extends Monitor {
    static CpuWindows micro;
    static MemoriaWindows memoria;
    static WindowsOS sistemaOperativo;
    
    
    static{  
        micro = new CpuWindows(); 
        memoria = new MemoriaWindows();
        sistemaOperativo = new WindowsOS();
    }
    
    
    public MonitorWindows() {
        super(MonitorWindows.micro, MonitorWindows.memoria, MonitorWindows.sistemaOperativo);
    }
}
