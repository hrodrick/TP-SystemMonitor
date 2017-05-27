
package monitor;

import monitor.Cpu.CpuWindows;
import monitor.Memoria.MemoriaWindows;
import monitor.Sensores.SensoresWindows;
import monitor.SistemaOperativo.WindowsOS;


public class MonitorWindows extends Monitor {
    static CpuWindows micro;
    static MemoriaWindows memoria;
    static WindowsOS sistemaOperativo;
    static SensoresWindows sensores;
    
    
    static{  
        micro = new CpuWindows(); 
        memoria = new MemoriaWindows();
        sistemaOperativo = new WindowsOS();
        sensores = new SensoresWindows();
    }
    
    
    public MonitorWindows() {
        super(micro, memoria, sistemaOperativo, sensores);
    }
}
