

package monitor;

import monitor.Memoria.Memoria;
import monitor.Sensores.Sensores;
import monitor.SistemaOperativo.OS;
import monitor.PlacaMadre.PlacaMadre;
import monitor.Cpu.CPU;


public abstract class Monitor {
    private CPU micro;
    private Memoria memory;
    private OS sistemaOperativo;
    private Sensores sensores;
    private PlacaMadre motherBoard;
    
    
    public Monitor(CPU micro, Memoria memory, OS sistemaOperativo, 
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
    
    public OS getSistemaOperativo(){
        return sistemaOperativo;
    }
    public Sensores getSensores(){
        return sensores;
    }
    public PlacaMadre getPlacaMadre(){
        return motherBoard;
    }
}
