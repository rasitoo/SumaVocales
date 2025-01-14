import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase SumaVocalesPadre se encarga de iniciar procesos hijo para contar las vocales en un archivo de entrada.
 * <p>
 * La clase lanza cinco procesos hijo, cada uno contando una vocal específica (a, e, i, o, u) en el archivo de entrada.
 * Luego, los resultados se escriben en archivos de salida separados.
 * <p>
 *
 * @author Chema y Rodrigo
 * @date 14 enero, 2025
 */
public class SumaVocalesPadre {
    List<Process> processes = new ArrayList<>();
    String[] vocals = {"a", "e", "i", "o", "u"};
    String[] outputFiles = {"resultadoa.txt", "resultadoe.txt", "resultadoi.txt", "resultadoo.txt", "resultadou.txt"};
    int numChildProcesses = vocals.length;


    /**
     * Inicia los procesos hijo para contar las vocales en el archivo de entrada.
     * <p>
     * Este método lanza cinco procesos hijo, cada uno contando una vocal específica en el archivo de entrada.
     * Los resultados se escriben en archivos de salida separados.
     * Espera a que todos los procesos terminen.
     * <p>
     *
     * @throws IOException Si ocurre un error de E/S.
     */
    public void iniciarProcesosHijo() throws IOException {
        String line;
        String inputFile = "entrada.txt";

        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < numChildProcesses; i++) {
                String vocal = vocals[i];
                String outputFile = outputFiles[i];

                ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target\\classes", "SumaVocalHijo");
                Process process = pb.start();
                processes.add(process);
                try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream())); PrintStream ps = new PrintStream(process.getOutputStream(), true)) {
                    //enviar mensajes al hijo
                    ps.println(inputFile);
                    ps.println(vocal);
                    ps.println(outputFile);
                    //recibir información del hijo, no se usa
//                    line = br.readLine();
//                    System.out.println(line);
                }
            }
        }
        //esperar a que todos los procesos hijo terminen
        for (Process process : processes) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void totalVocales() {
        int count = 0;
        for (int i = 0; i < outputFiles.length; i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader(outputFiles[i]))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    count += Integer.parseInt(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("En total hay " + count + " vocales");
    }
}
