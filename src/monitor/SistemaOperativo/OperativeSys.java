/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.SistemaOperativo;

import monitor.JSONSerializable;

/**
 *
 * @author Rodrigo Soria
 */
public interface OperativeSys extends JSONSerializable {
    public String getFamiliaOS();
    public String getVersionOS();
    public String getFabricanteOS();
    public String getEdicionOS();
}
