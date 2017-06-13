/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Sensores;

import monitor.JSONSerializable;

/**
 *
 * @author Rodrigo Soria
 */
public interface ISensores extends JSONSerializable{ //Ejemplo claro de interfaz que sólo posee métodos actualizables.
    public Double getTempCPU();
    public Double getVoltajeCPU();
    public int[] getVelVentiladores();
}
