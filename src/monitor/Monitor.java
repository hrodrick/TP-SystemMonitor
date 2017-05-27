

package monitor;

import monitor.Cpu.CPU;
import monitor.Memoria.Memoria;


public abstract class Monitor {
    private CPU micro;
    private Memoria memory;
    
    public Monitor(CPU micro, Memoria memory) {
        this.micro = micro;
        this.memory = memory;
    }
    
    public CPU getMicro() {
        return micro;
    }
    
    public Memoria getMemoria(){
        return memory;
    }
    
}
