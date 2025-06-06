import java.io.*;
import java.util.*;

public class EncuestaDAO {

    public void guardarEncuestas(String archivoSalida, List<String> datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            for (String linea : datos) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
