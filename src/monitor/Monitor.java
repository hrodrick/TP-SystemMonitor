package monitor;

import java.util.ArrayList;
import monitor.Cpu.ICPU;
import monitor.Memoria.IMemoria;
import monitor.NICS.INetworking;
import monitor.PlacaMadre.MotherBoard;
import monitor.Sensores.ISensores;
import monitor.SistemaOperativo.OperativeSys;
import org.json.JSONStringer;

public abstract class Monitor implements JSONSerializable{

    private ICPU micro;
    private IMemoria memory;
    private OperativeSys sistemaOperativo;
    private ISensores sensores;
    private MotherBoard motherBoard;
    private INetworking NICS;
    private ArrayList<String> serializables;

    public Monitor(ICPU micro, IMemoria memory, OperativeSys sistemaOperativo,
            ISensores sensores, MotherBoard placaMadre, INetworking nics) {

        this.micro = micro;
        this.memory = memory;
        this.sistemaOperativo = sistemaOperativo;
        this.sensores = sensores;
        this.motherBoard = placaMadre;
        this.NICS = nics;

    }

    public ICPU getMicro() {
        return micro;
    }

    public IMemoria getMemoria() {
        return memory;
    }

    public OperativeSys getSistemaOperativo() {
        return sistemaOperativo;
    }

    public ISensores getSensores() {
        return sensores;
    }

    public MotherBoard getPlacaMadre() {
        return motherBoard;
    }

    public INetworking getNetworks() {
        return NICS;
    }

    @Override
    public String toJson() {

        //TODO: debera retornar un String que sean todos los serializables juntos.
        //Serializables deben de ser todos los String de todos los TOJSON de los objetos del monitor.                        
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Procesador").value(this.micro.toJson())
                .key("Memoria").value(this.memory.toJson())
                .key("Sensores").value(this.sensores.toJson())
                .key("Sistema Operativo").value(this.sistemaOperativo.toJson())
                .key("NICS").value(this.NICS.toJson())
                .key("Placa Madre").value(this.motherBoard.toJson())                
                .endObject().toString();

        return Json;
    }
    @Override
    public String toString(){
        String res
                = "\n-------------Informacion del sistema-------------"
                + "\n" + sistemaOperativo.toString()
                + "\n-------------------------------------------------"
                + "\n" + motherBoard.toString()
                + "\n-------------------------------------------------"
                + "\n" + micro.toString()
                + "\n-------------------------------------------------"
                + "\n" + sensores.toString()
                + "\n-------------------------------------------------"
                +       memory.toString()
                + "\n-------------------------------------------------"
                + "\n" + NICS.toString();
        return res;
    }
}
