import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EncuestaDAO dao = new EncuestaDAO();

        List<String> preguntas = leerPreguntas("preguntas.txt");
        List<String> respuestas = new ArrayList<>();

        try (BufferedReader consola = new BufferedReader(new InputStreamReader(System.in))) {
            for (String pregunta : preguntas) {
                System.out.println(pregunta);
                System.out.print("Tu respuesta: ");
                String respuesta = consola.readLine();
                respuestas.add("Pregunta: " + pregunta);
                respuestas.add("Respuesta: " + respuesta);
                respuestas.add(""); // Línea vacía para separar
            }
        } catch (IOException e) {
            System.out.println("Error al leer desde consola: " + e.getMessage());
        }

        dao.guardarEncuestas("respuestas.txt", respuestas);
        System.out.println("Respuestas guardadas en respuestas.txt");
    }

    // Lee preguntas desde un archivo
    public static List<String> leerPreguntas(String archivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }
}
