/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Memoria;

import monitor.JSONSerializable;

/**
 *
 * @author Portatil
 */
public interface IMemoria extends JSONSerializable{
    public long getMemFisicaTotal();
    public long getMemFisicaDisponible();
    public long getMemFisicaUso();
    public long getMemSwapTotal();
    public long getMemSwapUso();
    public long getMemSwapDisponible();
    
}
