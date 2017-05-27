/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Memoria;
import oshi.hardware.common.AbstractGlobalMemory;
import oshi.hardware.platform.windows.WindowsGlobalMemory;


public class Memoria implements IMemoria{
    AbstractGlobalMemory memory;
    
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
    public long getMemFisicaUsada() {
        return (this.memory.getTotal() - this.memory.getAvailable());
    }

    @Override
    public long getMemIntercambioTotal() {
        return this.memory.getSwapTotal();
    }

    @Override
    public long getMemIntercambioUsada() {
        return this.memory.getSwapUsed();
    }

    @Override
    public long getMemIntercambioDisponible() {
        return  (this.memory.getSwapTotal() - this.memory.getSwapUsed());
    }
    
    
}