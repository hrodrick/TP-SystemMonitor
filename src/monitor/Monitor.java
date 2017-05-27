

package monitor;

import monitor.Cpu.CPU;
import monitor.Memoria.Memoria;
import monitor.SistemaOperativo.OperativeSystem;



public abstract class Monitor {
    private CPU micro;
    private Memoria memory;
    private OperativeSystem sistemaOperativo;
    
    public Monitor(CPU micro, Memoria memory, OperativeSystem sistemaOperativo) {
        this.micro = micro;
        this.memory = memory;
        this.sistemaOperativo = sistemaOperativo;
    }
    
    public CPU getMicro() {
        return micro;
    }
    
    public Memoria getMemoria(){
        return memory;
    }
    
    public OperativeSystem getSistemaOperativo(){
        return sistemaOperativo;
    }
    
}
