/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Memoria;
import oshi.hardware.common.AbstractGlobalMemory;


public abstract class Memoria implements IMemoria{
    private AbstractGlobalMemory memory;
    
    public Memoria(AbstractGlobalMemory a){
        this.memory = a;
    }

    @Override
    public long getMemFisicaTotal() {
        return this.memory.getTotal();
    }

    @Override
    public long getMemFisicaDisponible() {
        return this.memory.getAvailable();
    }

    @Override
    public long getMemFisicaUso() {
        return (this.memory.getTotal() - this.memory.getAvailable());
    }

    @Override
    public long getMemSwapTotal() {
        return this.memory.getSwapTotal();
    }

    @Override
    public long getMemSwapUso() {
        return this.memory.getSwapUsed();
    }

    @Override
    public long getMemSwapDisponible() {
        return  (this.memory.getSwapTotal() - this.memory.getSwapUsed());
    }
    @Override
    public String toJson() {       
        
        String Json = "{\"Memoria RAM total \":" + this.getMemFisicaTotal()
                + "\"Memoria RAM usada \":" + this.getMemFisicaUso()
                + "\"Memoria RAM disponible \":" + this.getMemFisicaDisponible()
                + "\"Memoria de intercambio total \":" + this.getMemSwapTotal()
                + "\"Memoria de intercambio usada\":" + this.getMemSwapUso()
                + "\"Memoria de intercambio disponible\":" + this.getMemSwapDisponible()+"}";
        
        return Json;
    }   
    
}
