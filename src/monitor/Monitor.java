

package monitor;

import monitor.Cpu.CPU;
import monitor.Memoria.Memoria;
import monitor.Sensores.Sensores;
import monitor.SistemaOperativo.OperativeSystem;
import monitor.PlacaMadre.PlacaMadre;


public abstract class Monitor {
    private CPU micro;
    private Memoria memory;
    private OperativeSystem sistemaOperativo;
    private Sensores sensores;
    private PlacaMadre motherBoard;
    
    
    public Monitor(CPU micro, Memoria memory, OperativeSystem sistemaOperativo, 
                   Sensores sensores, PlacaMadre placaMadre){
        
        this.micro = micro;
        this.memory = memory;
        this.sistemaOperativo = sistemaOperativo;
        this.sensores = sensores;
        this.motherBoard = placaMadre;
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
    public PlacaMadre getPlacaMadre(){
        return motherBoard;
    }
}
