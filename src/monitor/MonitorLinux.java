
package monitor;

import monitor.Cpu.CpuLinux;
import monitor.Memoria.MemoriaLinux;
import monitor.Sensores.SensoresLinux;
import monitor.SistemaOperativo.LinuxOS;

public class MonitorLinux extends Monitor {
    static CpuLinux micro;
    static MemoriaLinux memoria;
    static LinuxOS sistemaOperativo;
    static SensoresLinux sensores;
    
    static{ //Esto es un bloque de inicializacion statico. Se ejecuta antes que cualquier otra instruccion
        micro = new CpuLinux();
        memoria = new MemoriaLinux();
        sistemaOperativo = new LinuxOS();
        sensores = new SensoresLinux();
    }
    
    
    public MonitorLinux() {
        super(micro, memoria, sistemaOperativo, sensores);
    }
    
}
