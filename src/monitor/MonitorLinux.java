
package monitor;

import monitor.Cpu.CpuLinux;
import monitor.Memoria.MemoriaLinux;

public class MonitorLinux extends Monitor {
    static CpuLinux micro;
    static MemoriaLinux memoria;
    
    static{ //Esto es un bloque de inicializacion statico. Se ejecuta antes que cualquier otra instruccion
        micro = new CpuLinux();
        memoria = new MemoriaLinux();
    }
    
    
    public MonitorLinux() {
        super(MonitorLinux.micro, MonitorLinux.memoria);
    }
    
}
