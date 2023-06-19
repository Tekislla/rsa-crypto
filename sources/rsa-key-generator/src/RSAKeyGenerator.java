import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAKeyGenerator {
    public static void main(String[] args) {
        try {
            // Gerando par de chaves RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            // Definindo o tamanho da chave em 2048 bits
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Pegando a chave pública
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            BigInteger publicKeyModulus = publicKey.getModulus();
            BigInteger publicKeyExponent = publicKey.getPublicExponent();

            // Pegando a chave privada
            PrivateKey privateKey = keyPair.getPrivate();
            BigInteger privateKeyModulus = ((RSAPrivateKey) privateKey).getModulus();
            BigInteger privateKeyExponent = ((RSAPrivateKey) privateKey).getPrivateExponent();

            // Salvando a chave pública em um arquivo
            // Salvando módulo na primeira linha
            saveKeyToFile(publicKeyModulus, "public_key.txt");
            // Salvando expoente na segunda linha
            saveKeyToFile(publicKeyExponent, "public_key.txt", true);

            // Salvando a chave privada em um arquivo
            // Salvando módulo na primeira linha
            saveKeyToFile(privateKeyModulus, "private_key.txt");
            // Salvando expoente na segunda linha
            saveKeyToFile(privateKeyExponent, "private_key.txt", true);

            // Feedback para o usuário
            System.out.println("As chaves foram geradas.");
        } catch (NoSuchAlgorithmException | IOException e) {
            // Tratando possíveis exceptions com try/catch ao invés de declará-las na definição da função
            System.out.println("Erro ao gerar as chaves.\n");
            e.printStackTrace();
        }
    }

    // Polimorfismo: alterando a chamada da função saveKeyToFile para chamar a função principal com o parâmetro append pré-definido como false
    private static void saveKeyToFile(BigInteger key, String filename) throws IOException {
        saveKeyToFile(key, filename, false);
    }

    // Função para salvar a chave no arquivo
    private static void saveKeyToFile(BigInteger key, String filename, boolean append) throws IOException {
        String keyString = key.toString();

        FileWriter writer = new FileWriter(filename, append);
        writer.write(keyString);
        writer.write(System.lineSeparator());
        writer.close();
    }
}
