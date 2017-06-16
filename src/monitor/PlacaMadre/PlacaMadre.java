/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.PlacaMadre;

import org.json.JSONStringer;
import oshi.hardware.ComputerSystem;

/**
 *
 * @author Rodrigo Soria
 */
public abstract class PlacaMadre implements MotherBoard {

    private ComputerSystem sistema;

    PlacaMadre(ComputerSystem sistema) {
        this.sistema = sistema;

    }

    @Override
    public String getMarcaMother() {
        return sistema.getBaseboard().getManufacturer();
    }

    @Override
    public String getModeloMother() {
        return sistema.getBaseboard().getModel();
    }

    @Override
    public String toJson() {
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Marca").value(this.getMarcaMother())
                .key("Modelo").value(this.getModeloMother())
                .endObject().toString();

        return Json;
    }

    @Override
    public String toString() {
        String result = "Placa madre: "
                + "\nMarca: " + getMarcaMother()
                + "\nModelo: " + getModeloMother();
        return result;
    }
}
