package persistencia;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class ArchivoJSON {

    private static FileWriter file;            

    /**
     * Escribe la cadena JSON en el archivo
     *
     * @param cadenaJson
     * @param directorio
     */
    public void escribir(String cadenaJson, String directorio){
        this.abrir();
        PrintWriter pw = null;
        
        try {
            file = new FileWriter(directorio);
            pw = new PrintWriter(file);
            pw.print(cadenaJson);            

        } catch (IOException e) {
            System.err.println("Error al guardar el archivo.");
        }
        finally {
            try {
                // aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (file != null) {
                    file.close();
                }
            } catch (IOException e2) {
                System.err.println("Error al cerrar el archivo");
            }
        }
    }

    /**
     * Devuelve la cadena JSON asociada a la clave provista { 'pirulo': 'Esta es
     * la cadena asociada a pirluo' }
     *
     * @param clave
     * @return 'Esta es la cadena asociada a pirulo' si clave = 'pirulo'
     */
    public String leer(String clave) {
        this.abrir();
        /*
        ....
         */
        return "";
    }

    /**
     * Abre el archivo con el cual se va a interactuar
     */
    private void abrir() {
        /*
        ....
         */
    }

    @Override
    protected void finalize() throws Throwable {
        file.flush();
        file.close();
        super.finalize();
    }
}
