/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author Rodrigo Soria
 * Igual que ConsolePrinteable pero sólo para aquellas clases/interfaces que
 * posean datos que no sean fijos y puedan variar en tiempo de ejecucion.
*/
public interface ConsolePrinteableActualizable {
    
    public String toConsoleStringActualizable();
}
