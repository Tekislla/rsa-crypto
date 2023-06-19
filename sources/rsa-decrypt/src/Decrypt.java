import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;

public class Decrypt {
    public static void main(String[] args) {
        // Dando instruções de uso para o usuário caso ele não passe os 3 argumentos necessários
        if (args.length != 3) {
            System.out.println("Instruções de uso: java Decrypt <chave_privada>.txt <arquivo_texto_criptografado>.txt <arquivo_texto_saida>.txt");
            return;
        }

        // Jogando os valores dos argumentos em variáveis
        String privateKeyFile = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        try {
            // Leitura do arquivo de chave privada através de um reader
            BufferedReader keyReader = new BufferedReader(new FileReader(privateKeyFile));
            String keyLine = keyReader.readLine();
            // Pegando o módulo na primeira linha
            BigInteger nKey = new BigInteger(keyLine);
            keyLine = keyReader.readLine();
            // Pegando o expoente na segunda linha
            BigInteger dKey = new BigInteger(keyLine);
            // Fechando o reader
            keyReader.close();

            // Leitura do arquivo de entrada através de um reader
            BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
            String encryptedText = inputReader.readLine();
            // Fechando o reader
            inputReader.close();

            // Descriptografando o texto
            BigInteger numericText = new BigInteger(encryptedText);
            byte[] decryptedTextBytes = numericText.modPow(dKey, nKey).toByteArray();
            String decryptedText = new String(decryptedTextBytes);

            // Escrevendo o texto descriptografado no arquivo de saída
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile));
            outputWriter.write(decryptedText);
            outputWriter.close();

            System.out.println("Texto descriptografado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
