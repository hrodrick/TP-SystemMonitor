
package monitor;

import monitor.Cpu.CpuWindows;


public class MonitorWindows extends Monitor {
    static CpuWindows micro;
    static{ //Esto es un bloque de inicializacion statico. Se ejecuta antes de cualquier otra instruccion
            //En el inicio del programa.
        micro = new CpuWindows(); 
    }
    public MonitorWindows() {
        super(MonitorWindows.micro);
    }
}
