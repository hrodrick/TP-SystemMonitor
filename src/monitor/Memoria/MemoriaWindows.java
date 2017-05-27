/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Memoria;

import oshi.hardware.platform.windows.WindowsGlobalMemory;

/**
 *
 * @author Portatil
 */
public class MemoriaWindows extends Memoria{
    
    public MemoriaWindows(){
        super(new WindowsGlobalMemory());
    }
}
