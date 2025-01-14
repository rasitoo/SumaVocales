import java.io.*;
import java.text.Normalizer;

/**
 * La clase SumaVocalHijo se encarga de contar las ocurrencias de una vocal específica
 * en un archivo de entrada y escribir el resultado en un archivo de salida.
 * <p>
 *
 * La clase lee la ruta del archivo de entrada, la vocal a contar y la ruta del archivo de salida desde la entrada estándar.
 * Luego cuenta las ocurrencias de la vocal especificada (sin distinguir entre mayúsculas y minúsculas) en el archivo de entrada y escribe el conteo en el archivo de salida.
 * <p>
 *

 * Autor: Chema y Rodrigo
 * Fecha: 14 enero, 2025
 * </p>
 */
public class SumaVocalHijo {

    /**
     * El método main de la clase `SumaVocalHijo`.
     * <p>
     * Este método lee la ruta del archivo de entrada, la vocal a contar y la ruta del archivo de salida desde la entrada estándar.
     * Luego cuenta las ocurrencias de la vocal especificada (sin importar tilde, mayúscula o minúscula) en el archivo de entrada y escribe el conteo en el archivo de salida.
     * <p>
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void main(String[] args) throws IOException {
        String inputFile;
        char vocal;
        String outputFile;
        int count = 0;


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            inputFile = ".\\" + br.readLine();
            vocal = br.readLine().charAt(0);
            outputFile = br.readLine();
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //Separa las tildes con el normalizer
                line = Normalizer.normalize(line, Normalizer.Form.NFD);
                for (char c : line.toCharArray()) {
                    if (Character.toLowerCase(c) == Character.toLowerCase(vocal)) {
                        count++;
                    }
                }
            }
        }
        File f = new File(outputFile);
        f.createNewFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.valueOf(count));
        }

    }
}
