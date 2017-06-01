
package monitor;

import monitor.Cpu.CpuLinux;
import monitor.Memoria.MemoriaLinux;
import monitor.PlacaMadre.PlacaMadreLinux;
import monitor.Sensores.SensoresLinux;
import monitor.SistemaOperativo.LinuxOS;
import monitor.NICS.NetworkingLinux;

public class MonitorLinux extends Monitor {
    static CpuLinux micro;
    static MemoriaLinux memoria;
    static LinuxOS sistemaOperativo;
    static SensoresLinux sensores;
    static PlacaMadreLinux motherBoard;
    static NetworkingLinux NICS;
    
    static{ //Esto es un bloque de inicializacion statico.
        micro = new CpuLinux();
        memoria = new MemoriaLinux();
        sistemaOperativo = new LinuxOS();
        sensores = new SensoresLinux();
        motherBoard = new PlacaMadreLinux();
        NICS = new NetworkingLinux();
    }
    
    
    public MonitorLinux() {
        super(micro, memoria, sistemaOperativo, sensores, motherBoard, NICS);
    }
    
}
