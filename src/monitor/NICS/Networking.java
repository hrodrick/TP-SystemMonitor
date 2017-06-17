package monitor.NICS;

import java.util.ArrayList;
import org.json.JSONObject;
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
        //JSONStringer js = new JSONStringer();                        
        /* Forma vieja y rara que no funca
        for (INIC i : nics) {
            js.value(i.toJson());
        } 
        */
        //Forma piola que anda
        JSONObject js = new JSONObject();        
        for(int i = 0; i<nics.size();i++){
            js.append("Red:"+i,nics.get(i).toJson());            
        }
        String json = js.toString();

        return json;
    }

    @Override
    public String toString() {
        String result = "Networks: ";
        int i = 0;
        for (INIC controller : nics) {
            i++;
            result = result.concat("\nNIC "+ i +":\n"+ controller.toString());
        }
        return result;
    }

}
