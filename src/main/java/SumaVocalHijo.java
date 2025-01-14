import java.io.*;

/**
 * @author Chema y Rodrigo
 * @date 14 enero, 2025
 */
public class SumaVocalHijo {

    public static void main(String[] args) throws IOException {
        String inputFile;
        char vocal;
        String outputFile;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            inputFile = br.readLine();
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
        System.out.println("asdasdsassad");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write(String.valueOf(contar));
            System.out.println(contar);
        }

    }
}
