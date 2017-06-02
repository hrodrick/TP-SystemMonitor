/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.NICS;

import java.util.ArrayList;
import monitor.JSONSerializable;

/**
 *
 * @author Rodrigo Soria
 */
public interface INetworking{
   
    public ArrayList<NIC> getNics();
}
