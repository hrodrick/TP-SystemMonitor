/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.NICS;

import java.util.ArrayList;
import org.json.JSONStringer;
import oshi.hardware.NetworkIF;
import oshi.hardware.common.AbstractNetworks;

public abstract class Networking implements INetworking {

    private AbstractNetworks networks;
    protected ArrayList<INIC> nics;

    public Networking(AbstractNetworks nets) {
        networks = nets;
        nics = new ArrayList<>();
        establecerTodasLasNics(networks.getNetworks());
    }

    @Override
    public ArrayList<INIC> getNics() {
        return nics;
    }

    protected abstract void establecerTodasLasNics(NetworkIF[] nics);

    @Override
    public String toJson() {
        JSONStringer js = new JSONStringer();
        for (INIC i : nics) {
            js.value(i.toJson());
        }
        String json = js.endArray().toString();

        return json;
    }

    @Override
    public String toConsoleString() {
        String result = "Networks: ";
        int i = 0;
        for (INIC controller : nics) {
            i++;
            result = result.concat("\nNIC "+ i +":\n"+ controller.toConsoleString());
        }
        return result;
    }

}
