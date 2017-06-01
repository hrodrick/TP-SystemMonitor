
package monitor;

import monitor.Cpu.CpuWindows;
import monitor.Memoria.MemoriaWindows;
import monitor.PlacaMadre.PlacaMadreWindows;
import monitor.Sensores.SensoresWindows;
import monitor.SistemaOperativo.WindowsOS;
import monitor.NICS.NetworkingWindows;

public class MonitorWindows extends Monitor {
    static CpuWindows micro;
    static MemoriaWindows memoria;
    static WindowsOS sistemaOperativo;
    static SensoresWindows sensores;
    static PlacaMadreWindows motherBoard;
    static NetworkingWindows NICS;
    
    static{  
        micro = new CpuWindows(); 
        memoria = new MemoriaWindows();
        sistemaOperativo = new WindowsOS();
        sensores = new SensoresWindows();
        motherBoard = new PlacaMadreWindows();        
        NICS = new NetworkingWindows();
    }
    
    
    public MonitorWindows() {
        super(micro, memoria, sistemaOperativo, sensores, motherBoard, NICS);
    }
}
