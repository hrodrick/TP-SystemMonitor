

package monitor;

import monitor.Cpu.CPU;


public abstract class Monitor {
    private CPU micro;

    
    public Monitor(CPU micro) {
        this.micro = micro;
    }
    
    public CPU getMicro() {
        return micro;
    }

    
}
