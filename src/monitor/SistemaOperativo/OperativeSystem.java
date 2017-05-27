/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.SistemaOperativo;
import oshi.software.common.AbstractOperatingSystem;
/**
 *
 * @author Rodrigo Soria
 */
public class OperativeSystem implements OS{
    AbstractOperatingSystem opSystem;
    
    public OperativeSystem(AbstractOperatingSystem opSystem){
        this.opSystem = opSystem;
    }
    
    @Override
    public String getFamiliaOS() {
        return opSystem.getFamily();
    }

    @Override
    public String getVersionOS() {
        return opSystem.getVersion().getVersion();
    }

    @Override
    public String getFabricanteOS() {
        return opSystem.getManufacturer();
    }
    @Override
    public String getEdicionOS(){
        return opSystem.getVersion().getCodeName();
    }
    
}
