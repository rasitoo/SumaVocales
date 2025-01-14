import java.util.ArrayList;
import java.util.List;

/**
 * @author Chema y Rodrigo
 * @date 14 enero, 2025
 */
public class SumaVocales {
    int numProcesosHijo = 5;
    List<ProcessBuilder> processBuilders = new ArrayList<>();
    List<Process> procesos = new ArrayList<>();


    public void iniciarProcesosHijo() {
        ProcessBuilder pb = new ProcessBuilder(contarVocales('a'));
        pb.redirectErrorStream(true);
        processBuilders.add(pb);
    }

    private List<String> contarVocales(char a) {
    }
}
