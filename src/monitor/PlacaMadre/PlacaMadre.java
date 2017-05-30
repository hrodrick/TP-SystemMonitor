/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.PlacaMadre;

import monitor.JSONSerializable;
import oshi.hardware.ComputerSystem;

/**
 *
 * @author Rodrigo Soria
 */
public abstract class PlacaMadre implements MotherBoard,
                                            JSONSerializable {

    private ComputerSystem sistema;

    PlacaMadre(ComputerSystem sistema) {
        this.sistema = sistema;

    }

    @Override
    public String getMarcaMother() {
        return sistema.getBaseboard().getManufacturer();
    }

    @Override
    public String getModeloMother() {
        return sistema.getBaseboard().getModel();
    }
    
    @Override
    public String toJson() {             
        
        String Json = "{\"Marca Placa madre \":" + this.getMarcaMother()                
                + "\"Modelo placa madre \":" + this.getModeloMother()+"}";
        
        return Json;
    }


}
