package encrypt;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class DefaultEncryptor implements Encryptor {
    private final SecureRandom random = new SecureRandom();
    private static final String ALPHABET =
            "abcdefghijklmnopqrstuvwxyz" +
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "0123456789" +
                    "-:." +
                    " ,!?;_()+=/@#$%&*";
    private final Map<Character, Character> encryptTable = new HashMap<Character, Character>();
    private final Map<Character, Character> decryptTable = new HashMap<Character, Character>();

    public DefaultEncryptor() {
        String key = generateKey();
        for (int i = 0; i < ALPHABET.length(); i++) {
            char k = ALPHABET.charAt(i);
            char v = key.charAt(i);
            encryptTable.put(k, v);
            decryptTable.put(v, k);
        }
    }

    @Override
    public String encrypt(String text) {
        return translate(text, encryptTable);
    }

    @Override
    public String decrypt(String text) {
        return translate(text, decryptTable);
    }

    private String translate(String text, Map<Character, Character> table) {
        StringBuilder res = new StringBuilder(text.length());
        for (char c : text.toCharArray()) {
            res.append(table.getOrDefault(c, c));
        }
        return res.toString();
    }

    private String generateKey() {
        char[] charKey = ALPHABET.toCharArray();
        for (int i = charKey.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = charKey[i];
            charKey[i] = charKey[j];
            charKey[j] = temp;
        }
        return new String(charKey);
    }
}
