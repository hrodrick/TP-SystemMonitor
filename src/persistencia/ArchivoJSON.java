package persistencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
    public String leer(String clavem, String directorio) throws FileNotFoundException {
        this.abrir(directorio);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader(directorio);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;

            while ((linea = br.readLine()) != null) {               
                        System.out.println("se encontro la palabra " + linea);          
                
            }
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
        return "";
    }

    @Override
    protected void finalize() throws Throwable {
        file.flush();
        file.close();
        super.finalize();
    }
}
