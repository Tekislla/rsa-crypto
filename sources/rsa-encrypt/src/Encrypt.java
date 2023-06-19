import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Encrypt {
    public static void main(String[] args) {
        // Dando instruções de uso para o usuário caso ele não passe os 3 argumentos necessários
        if (args.length != 3) {
            System.out.println("Instruções de uso: java Encrypt <chave_pública>.txt <texto_entrada>.txt <texto_saída>.txt");
            return;
        }

        // Jogando os valores dos argumentos em variáveis
        String publicKeyFile = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        try {
            // Leitura do arquivo de chave pública
            List<String> keys = Files.readAllLines(Paths.get(publicKeyFile));
            // Pegando o módulo na primeira linha
            BigInteger nKey = new BigInteger(keys.get(0));
            // Pegando o expoente na segunda linha
            BigInteger eKey = new BigInteger(keys.get(1));

            // Leitura do arquivo de entrada
            byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
            String inputText = new String(inputBytes, StandardCharsets.UTF_8);

            // Criptografando o texto
            BigInteger numericText = new BigInteger(inputText.getBytes(StandardCharsets.UTF_8));
            BigInteger encryptedText = numericText.modPow(eKey, nKey);

            // Escrevendo o texto criptografado no arquivo de saída
            try (BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile))) {
                outputWriter.write(encryptedText.toString());
            }

            // Feedback para o usuário
            System.out.println("Texto criptografado com sucesso.");
        } catch (IOException e) {
            // Tratando a possível exception com try/catch ao invés de declará-la no método
            System.out.println("Erro ao criptografar o texto.\n");
            e.printStackTrace();
        }
    }
}