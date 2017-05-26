/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author Alumno
 */
public interface CPU {
    public String getFamilia();
    public String getModelo();
    public String getFabricante();
    public Boolean esDe64Bits();
}
