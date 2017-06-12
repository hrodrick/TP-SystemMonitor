/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.NICS;

import monitor.ConsolePrinteable;
import monitor.ConsolePrinteableActualizable;
import monitor.JSONSerializable;

/**
 *
 * @author Rodrigo Soria
 */
public interface INIC extends JSONSerializable,
                              ConsolePrinteable,
                              ConsolePrinteableActualizable{
    public String[] getIPv4();
    public String getMacAdress();
    public String getNombre();
    public long getBytesRecibidos();
    public long getBytesEnviados();
}
