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
public abstract class OS implements OperativeSys{
    
    private AbstractOperatingSystem opSystem;
    
    public OS(AbstractOperatingSystem opSystem){
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
    
    @Override
    public String toJson() {                      
        
        String Json = "{\"Fabricante SO \":" + this.getFabricanteOS()
                + "\"Familia SO \":" + this.getFamiliaOS()
                + "\"Version SO \":" + this.getVersionOS()
                + "\"Edicion SO \":" + this.getVersionOS()+"}";
        
        return Json;
    }
    
    
}
