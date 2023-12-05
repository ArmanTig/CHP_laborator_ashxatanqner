ackage org.example.Vijiner;

public class VigenereSimple {

    public static String encode(String plainText, String key) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < plainText.length(); ++i) {
            char currentChar = plainText.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                char encodedChar = (char)('a' + ((Character.toLowerCase(currentChar) - 'a') + (Character.toLowerCase(key.charAt(i % key.length())) - 'a')) % 26);
                if (Character.isUpperCase(currentChar)) {
                    encodedChar = Character.toUpperCase(encodedChar);
                }
                encoded.append(encodedChar);
            } else {
                encoded.append(currentChar);
            }
        }
        return encoded.toString();
    }

    public static String decode(String ciphertext, String key) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); ++i) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                char decodedChar = (char)('a' + ((Character.toLowerCase(currentChar) - 'a') - (Character.toLowerCase(key.charAt(i % key.length())) - 'a') + 26) % 26);
                if (Character.isUpperCase(currentChar)) {
                    decodedChar = Character.toUpperCase(decodedChar);
                }

                decoded.append(decodedChar);
            } else {
                decoded.append(currentChar);
            }
        }

        return decoded.toString();
    }

    public static void main(String[] args) {
        String plainTxt = "ATTACKATDAWN";
        String key = "Lemon";
        String result = encode(plainTxt, key);
        System.out.println("Plaintext: " + plainTxt);
        System.out.println("Encoded: " + result);
        result = decode(result, key);
        System.out.println("Decoded: " + result);
    }
}
