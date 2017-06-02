/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.PlacaMadre;

import monitor.JSONSerializable;

/**
 *
 * @author Rodrigo Soria
 */
public interface MotherBoard extends JSONSerializable{
    public String getMarcaMother();
    public String getModeloMother();
}
