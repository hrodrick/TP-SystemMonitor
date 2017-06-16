package persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;


public class ArchivoJSON {

    private static FileWriter file;   

    public void escribir(String cadenaJson, String directorio) {
        this.abrir(directorio);
        try {
            file.write(cadenaJson);
            if (file != null) {
                file.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrir(String directorio) {

        try {
            if (file == null) {
                file = new FileWriter(directorio);
            }

        } catch (IOException e) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    /**
     * Devuelve la cadena JSON asociada a la clave provista { 'pirulo': 'Esta es
     * la cadena asociada a pirluo' }
     *
     * @param clave
     * @return 'Esta es la cadena asociada a pirulo' si clave = 'pirulo'
     */
    public String leer(String clavem, String directorio){
        this.abrir(directorio);
        FileReader fr = null;
        BufferedReader br = null;
        String json = null;                
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(directorio);
            br = new BufferedReader(fr);
            // Lectura del fichero            
            json=br.readLine();    
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                    br.close();
                    file.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        ///Se instancia un JSON llamando al constructor que te pide un String
        ///en este caso lo que se leyo del archivo, me costo un huevo darme cuenta.
        JSONObject o = new JSONObject(json);              
        return o.getString(clavem);
    }

    @Override
    protected void finalize() throws Throwable {
        file.flush();
        file.close();
        super.finalize();
    }
}