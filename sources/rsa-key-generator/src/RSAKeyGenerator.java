import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSAKeyGenerator {
    public static void main(String[] args) {
        // Definindo o tamanho do número primo p
        int keySize = 1024;

        // Gerando os números primos p e q
        BigInteger p = generatePrimeNumber(keySize);
        BigInteger q = generatePrimeNumber(keySize);

        // Calculando o módulo n
        BigInteger n = p.multiply(q);

        // Calculando a função totiente de Euler
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Gerando o expoente de criptografia e
        BigInteger e = generateEncryptionExponent(phi);

        // Calculando o expoente de descriptografia d
        BigInteger d = e.modInverse(phi);

        // Escrevendo as chaves no arquivo
        writeKeysToFile(n, e, d);
    }

    // Função para gerar um número primo sem precisar duplicar o código
    private static BigInteger generatePrimeNumber(int bitLength) {
        SecureRandom random = new SecureRandom();
        return BigInteger.probablePrime(bitLength, random);
    }

    // Função para gerar o expoente de criptografia
    private static BigInteger generateEncryptionExponent(BigInteger phi) {
        BigInteger e = BigInteger.valueOf(65537);
        while (e.gcd(phi).compareTo(BigInteger.ONE) != 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }
        return e;
    }

    // Função para escrever as chaves nos arquivo
    private static void writeKeysToFile(BigInteger n, BigInteger e, BigInteger d) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("public_key.txt"))) {
            writer.write(n.toString());
            writer.newLine();
            writer.write(e.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("private_key.txt"))) {
            writer.write(n.toString());
            writer.newLine();
            writer.write(d.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
