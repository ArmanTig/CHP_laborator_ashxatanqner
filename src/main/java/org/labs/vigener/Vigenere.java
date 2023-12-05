package  org.example.Vijiner;

public class Vigenere {

    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);

            char keyChar = key.charAt(i % keyLength);

            int encryptedChar = (plainChar + keyChar) % Character.MAX_VALUE;

            ciphertext.append((char) encryptedChar);
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);

            char keyChar = key.charAt(i % keyLength);

            int decryptedChar = (cipherChar - keyChar + Character.MAX_VALUE) % Character.MAX_VALUE;

            plaintext.append((char) decryptedChar);
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        String plaintext = "Hello, World! 123";
        String key = "KEY";

        // Encrypt the message
        String encryptedMessage = encrypt(plaintext, key);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
