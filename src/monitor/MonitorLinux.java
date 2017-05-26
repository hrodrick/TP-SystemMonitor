
package monitor;

public class MonitorLinux extends Monitor {
    static CpuLinux micro;
    static{ //Esto es un bloque de inicializacion statico. Se ejecuta ni bien se ejecuta la linea Main.
        micro = new CpuLinux(); 
    }
    public MonitorLinux() {
        super(MonitorLinux.micro);
    }
    
}
