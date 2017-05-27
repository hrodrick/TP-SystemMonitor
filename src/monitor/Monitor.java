

package monitor;

import monitor.Cpu.CPU;
import monitor.Memoria.Memoria;
import monitor.Sensores.Sensores;
import monitor.SistemaOperativo.OperativeSystem;



public abstract class Monitor {
    private CPU micro;
    private Memoria memory;
    private OperativeSystem sistemaOperativo;
    private Sensores sensores;
    
    public Monitor(CPU micro, Memoria memory, OperativeSystem sistemaOperativo, 
                   Sensores sensores){
        
        this.micro = micro;
        this.memory = memory;
        this.sistemaOperativo = sistemaOperativo;
        this.sensores = sensores;
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
    public Sensores getSensores(){
        return sensores;
    }
    
}
