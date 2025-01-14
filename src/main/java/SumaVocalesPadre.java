import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Chema y Rodrigo
 * @date 14 enero, 2025
 */
public class SumaVocalesPadre {
    int numProcesosHijo = 5;
    List<Process> procesess = new ArrayList<>();
    String[] vocales = {"a", "e", "i", "o", "u"};


    public void iniciarProcesosHijo() throws IOException {
        String line;
        String entrada = "Lectura.txt";

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
