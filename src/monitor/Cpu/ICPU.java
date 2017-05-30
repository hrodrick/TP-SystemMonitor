/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Cpu;

/**
 *
 * @author Alumno
 */
public interface ICPU {
    public String getFamiliaCPU();
    public String getModeloCPU();
    public String getFabricanteCPU();
    public Boolean esDe64Bits();
    public String getNombreCPU();
    public int getNucleosLogicosCPU();
    public int getNucleosFisicosCPU();
    public double getUsoActualCPU();
}