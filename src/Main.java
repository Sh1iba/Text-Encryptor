
import encrypt.DefaultEncryptor;
import encrypt.MessageEncryptor;
import model.EncryptedMessage;
import model.Message;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        MessageEncryptor messageEncryptor = new MessageEncryptor(new DefaultEncryptor());
        Message message = new Message();
        message.setMessage("\"Unnatural!\" She suddenly recalled the word " +
                "that had stung her most of all, not so much the word itself as " +
                "the intent to wound her with which it was said.");
        message.setTimestamp(LocalDateTime.now());
        System.out.printf("Сообщение: %s%n", message.getMessage());
        System.out.printf("Время отправки: %s%n%n", message.getTimestamp());
        EncryptedMessage encrypted = messageEncryptor.encrypt(message);
        System.out.printf("Зашифрованное сообщение: %s%n", encrypted.getMessage());
        System.out.printf("Зашифрованное время отправки: %s%n%n", encrypted.getTimestamp());
        Message decrypted = messageEncryptor.decrypt(encrypted);
        System.out.printf("Расшифрованное сообщение: %s%n", decrypted.getMessage());
        System.out.printf("Расшифрованное время отправки: %s%n", decrypted.getTimestamp());
        System.out.println(message.hashCode());
        System.out.println(decrypted.hashCode());
        System.out.println(message.equals(decrypted));

    }
}