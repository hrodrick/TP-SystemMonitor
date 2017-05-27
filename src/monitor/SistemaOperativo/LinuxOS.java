/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.SistemaOperativo;

import oshi.software.os.linux.LinuxOperatingSystem;

/**
 *
 * @author Rodrigo Soria
 */
public class LinuxOS extends OperativeSystem{
    
    public LinuxOS(){
        super(new LinuxOperatingSystem());
    }
}
