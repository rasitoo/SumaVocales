import java.io.*;

/**
 * La clase SumaVocalHijo se encarga de contar las ocurrencias de una vocal específica
 * en un archivo de entrada y escribir el resultado en un archivo de salida.
 *
 *
 * La clase lee la ruta del archivo de entrada, la vocal a contar y la ruta del archivo de salida desde la entrada estándar.
 * Luego cuenta las ocurrencias de la vocal especificada (sin distinguir entre mayúsculas y minúsculas) en el archivo de entrada y escribe el conteo en el archivo de salida.
 *
 *

 * Autor: Chema y Rodrigo
 * Fecha: 14 enero, 2025
 * </p>
 */
public class SumaVocalHijo {

    /**
     * El método main de la clase `SumaVocalHijo`.
     *
     * Este método lee la ruta del archivo de entrada, la vocal a contar y la ruta del archivo de salida desde la entrada estándar.
     * Luego cuenta las ocurrencias de la vocal especificada (sin distinguir entre mayúsculas y minúsculas) en el archivo de entrada y escribe el conteo en el archivo de salida.
     *
     * Habría que añadirle una forma de contar vocales con tilde
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void main(String[] args) throws IOException {
        String inputFile;
        char vocal;
        String outputFile;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            inputFile = ".\\" + br.readLine();
            vocal = br.readLine().charAt(0);
            outputFile = br.readLine();
        }

        int contar = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.toLowerCase(c) == Character.toLowerCase(vocal)) {
                        contar++;

                    }
                }
            }
        }
        File f = new File(outputFile);
        f.createNewFile();
        System.out.println("Hay " + contar + " " + vocal);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write(String.valueOf(contar));
            System.out.println(contar);
        }

    }
}
