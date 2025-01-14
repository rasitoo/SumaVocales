import java.io.IOException;

/**
 * La clase `Main` es el punto de entrada del programa.
 * <p>
 * Esta clase crea una instancia de `SumaVocalesPadre` y llama al método `iniciarProcesosHijo` para iniciar los procesos hijo que contarán las vocales en el archivo de entrada.
 * </p>
 * <p>
 * Autor: Chema y Rodrigo
 * Fecha: 14 enero, 2025
 * </p>
 *
 * @author Chema y Rodrigo
 * @date 14 enero, 2025
 */
public class Main {
    /**
     * El método main de la clase `Main`.
     * <p>
     * Este método crea una instancia de `SumaVocalesPadre` y llama al método `iniciarProcesosHijo` para iniciar los procesos hijo que contarán las vocales en el archivo de entrada.
     * </p>
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SumaVocalesPadre ej = new SumaVocalesPadre();
        try {
            ej.iniciarProcesosHijo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
