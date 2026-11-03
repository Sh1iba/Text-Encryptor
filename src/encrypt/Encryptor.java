package encrypt;


public interface Encryptor {

    String encrypt(String text);

    String decrypt(String text);
}
