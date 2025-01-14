import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase `SumaVocalesPadre` se encarga de iniciar procesos hijo para contar las vocales en un archivo de entrada.
 * <p>
 * La clase lanza cinco procesos hijo, cada uno contando una vocal específica (a, e, i, o, u) en el archivo de entrada.
 * Luego, los resultados se escriben en archivos de salida separados.
 * </p>
 * <p>
 * Autor: Chema y Rodrigo
 * Fecha: 14 enero, 2025
 * </p>
 *
 * @author Chema y Rodrigo
 * @date 14 enero, 2025
 */
public class SumaVocalesPadre {
    int numProcesosHijo = 5;
    List<Process> procesess = new ArrayList<>();
    String[] vocales = {"a", "e", "i", "o", "u"};


    /**
     * Inicia los procesos hijo para contar las vocales en el archivo de entrada.
     * <p>
     * Este método lanza cinco procesos hijo, cada uno contando una vocal específica en el archivo de entrada.
     * Los resultados se escriben en archivos de salida separados.
     * </p>
     *
     * @throws IOException Si ocurre un error de E/S.
     */
    public void iniciarProcesosHijo() throws IOException {
        String line;
        String entrada = "entrada.txt";

        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < numProcesosHijo; i++) {
                String vocal = vocales[i];
                String outputFile = "resultado" + vocal + ".txt";

                ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target\\classes", "SumaVocalHijo");
                Process process = pb.start();
                procesess.add(process);
                try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                     PrintStream ps = new PrintStream(process.getOutputStream(), true)) {

                    // Enviar mensajes al hijo
                    ps.println(entrada);
                    ps.println(vocal);
                    ps.println(outputFile);
                    // Recibir información del hijo
                    line = br.readLine();
                    System.out.println(line);
                }
            }
        }
    }
}
