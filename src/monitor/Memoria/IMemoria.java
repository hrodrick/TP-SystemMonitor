/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Memoria;

/**
 *
 * @author Portatil
 */
public interface IMemoria {
    public long getMemFisicaTotal();
    public long getMemFisicaDisponible();
    public long getMemFisicaUsada();
    public long getMemIntercambioTotal();
    public long getMemIntercambioUsada();
    public long getMemIntercambioDisponible();
    
}
