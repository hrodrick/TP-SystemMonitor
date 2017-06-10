/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author Rodrigo Soria
 *En vez de utilizar el método ToString de Object creé una interfaz cuya finalidad
 *es la de organizar sólo las clases que deseo que muestren información pero con
 *formato exclusivo para una correcta salida por consola y una alta legibilidad,
 *como se indica tanto en su nombre como en su método.
*/
public interface ConsolePrinteable {
    
    public String toConsoleString();
}
