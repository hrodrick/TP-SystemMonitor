/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Memoria;

import org.json.JSONStringer;
import oshi.hardware.common.AbstractGlobalMemory;

public abstract class Memoria implements IMemoria {

    private AbstractGlobalMemory memory;

    public Memoria(AbstractGlobalMemory a) {
        this.memory = a;
    }

    @Override
    public long getMemFisicaTotal() {
        return this.memory.getTotal();
    }

    @Override
    public long getMemFisicaDisponible() {
        return this.memory.getAvailable();
    }

    @Override
    public long getMemFisicaUso() {
        return (this.memory.getTotal() - this.memory.getAvailable());
    }

    @Override
    public long getMemSwapTotal() {
        return this.memory.getSwapTotal();
    }

    @Override
    public long getMemSwapUso() {
        return this.memory.getSwapUsed();
    }

    @Override
    public long getMemSwapDisponible() {
        return (this.memory.getSwapTotal() - this.memory.getSwapUsed());
    }

    @Override
    public String toJson() {

        /*Forma chota y vieja
        String Json = "{\"Memoria RAM total \":\"" +this.getMemFisicaTotal()+"\","
                + "\"Memoria RAM usada \":\"" +this.getMemFisicaUso()+"\","
                + "\"Memoria RAM disponible \":\"" +this.getMemFisicaDisponible()+"\","
                + "\"Memoria de intercambio total \":\"" +this.getMemSwapTotal()+"\","
                + "\"Memoria de intercambio usada\":\"" + this.getMemSwapUso()+"\","
                + "\"Memoria de intercambio disponible\":\"" +this.getMemSwapDisponible()+"\"}";
         */
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Memoria fisica disponible").value(this.getMemFisicaDisponible())
                .key("Memoria fisica total").value(this.getMemFisicaTotal())
                .key("Memoria fisica en uso").value(this.getMemFisicaUso())
                .key("Memoria swap disponible").value(this.getMemSwapDisponible())
                .key("Memoria swap en uso").value(this.getMemSwapUso())
                .key("Memoria swap total").value(this.getMemSwapTotal())
                .endObject().toString();

        return Json;
    }

    @Override
    public String toConsoleString() {
        String result = "Memoria del sistema: "
                + "\nMemoria RAM total: " + getMemFisicaTotal()/1024/1024+"mb."
                + "\nMemoria SWAP total: " + getMemSwapTotal()/1024/1024+"mb.";

        return result;
    }

    @Override
    public String toConsoleStringActualizable() {
        String result = "Uso de RAM: " + getMemFisicaUso()/1024/1024+"mb."
                + "\nRAM disponible : " + getMemFisicaDisponible()/1024/1024+"mb."
                + "\nSWAP en uso: " + getMemSwapUso()/1024/1024+"mb."
                + "\nSWAP disponible: " + getMemSwapDisponible()/1024/1024+"mb.";

        return result;
    }

}
