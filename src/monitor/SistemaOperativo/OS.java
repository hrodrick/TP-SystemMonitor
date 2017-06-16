/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.SistemaOperativo;

import org.json.JSONStringer;
import oshi.software.common.AbstractOperatingSystem;

/**
 *
 * @author Rodrigo Soria
 */
public abstract class OS implements OperativeSys {

    private AbstractOperatingSystem opSystem;

    public OS(AbstractOperatingSystem opSystem) {
        this.opSystem = opSystem;
    }

    @Override
    public String getFamiliaOS() {
        return opSystem.getFamily();
    }

    @Override
    public String getVersionOS() {
        return opSystem.getVersion().getVersion();
    }

    @Override
    public String getFabricanteOS() {
        return opSystem.getManufacturer();
    }

    @Override
    public String getEdicionOS() {
        return opSystem.getVersion().getCodeName();
    }

    @Override
    public String toJson() {
        JSONStringer js = new JSONStringer();
        String Json = js.object()
                .key("Familia").value(this.getFamiliaOS())
                .key("Facribante").value(this.getFabricanteOS())
                .key("Edicion").value(this.getEdicionOS())
                .key("Version").value(this.getVersionOS())
                .endObject().toString();
        return Json;
    }

    @Override
    public String toString() {
        String result = "\nFabricante: " + getFabricanteOS()
                + "Sistema operativo: " + getFamiliaOS()
                + "\nVersion: " + getVersionOS()
                + "\nEdicion: " + getEdicionOS();

        return result;
    }

}
