
package monitor;

import monitor.Cpu.CpuLinux;
import monitor.Memoria.MemoriaLinux;
import monitor.SistemaOperativo.LinuxOS;

public class MonitorLinux extends Monitor {
    static CpuLinux micro;
    static MemoriaLinux memoria;
    static LinuxOS sistemaOperativo;
    
    static{ //Esto es un bloque de inicializacion statico. Se ejecuta antes que cualquier otra instruccion
        micro = new CpuLinux();
        memoria = new MemoriaLinux();
        sistemaOperativo = new LinuxOS();
    }
    
    
    public MonitorLinux() {
        super(MonitorLinux.micro, MonitorLinux.memoria, MonitorLinux.sistemaOperativo);
    }
    
}
