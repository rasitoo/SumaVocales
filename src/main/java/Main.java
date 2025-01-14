import java.io.IOException;

/**
 * @author Rodrigo
 * @date 14 enero, 2025
 */
public class Main {
    //El proceso hijo recibirá del padre la vocal que tiene que contar y el fichero
    public static void main(String[] args) {
        SumaVocalesPadre ej = new SumaVocalesPadre();
        try {
            ej.iniciarProcesosHijo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
