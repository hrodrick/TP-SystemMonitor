

package monitor;

import monitor.Memoria.Memoria;
import monitor.Sensores.Sensores;
import monitor.SistemaOperativo.OS;
import monitor.PlacaMadre.PlacaMadre;
import monitor.Cpu.CPU;
import monitor.NICS.Networking;


public abstract class Monitor implements JSONSerializable{
    //TODO: ESTOS OBJETOS DEBEN SER DEL TIPO DE LA INTERFAZ. NO DE LA CLASE. A su vez renombrar las demas clases
    private CPU micro;
    private Memoria memory;
    private OS sistemaOperativo;
    private Sensores sensores;
    private PlacaMadre motherBoard;
    private Networking NICS;
    
    
    public Monitor(CPU micro, Memoria memory, OS sistemaOperativo, 
                   Sensores sensores, PlacaMadre placaMadre, Networking nics){
        
        this.micro = micro;
        this.memory = memory;
        this.sistemaOperativo = sistemaOperativo;
        this.sensores = sensores;
        this.motherBoard = placaMadre;
        this.NICS = nics;
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
    public Networking getNetworks(){
        return NICS;
    }
    @Override
    public String toJson() {        
        String Json = null;
        
        return Json;
    }
}
