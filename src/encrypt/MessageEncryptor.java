package encrypt;

import model.EncryptedMessage;
import model.Message;

import java.time.LocalDateTime;

public class MessageEncryptor {
    private final Encryptor encryptor;

    public MessageEncryptor(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    public EncryptedMessage encrypt(Message message) {
        return new EncryptedMessage(
                encryptor.encrypt(message.getMessage()),
                encryptor.encrypt(message.getTimestamp().toString()));
    }

    public Message decrypt(EncryptedMessage encryptedMessage) {
        return new Message(
                encryptor.decrypt(encryptedMessage.getMessage()),
                LocalDateTime.parse(encryptor.decrypt(encryptedMessage.getTimestamp())));
    }

}
