/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Memoria;

import oshi.hardware.platform.linux.LinuxGlobalMemory;

/**
 *
 * @author Portatil
 */
public class MemoriaLinux extends Memoria{
    
    public MemoriaLinux(){
        super(new LinuxGlobalMemory());
    }
}
