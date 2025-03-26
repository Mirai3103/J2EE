package sgu.demo.authorservice;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import java.util.function.Supplier;

@Service
public class RabbitMQProducer {
    private final Supplier<Message<String>> messageSupplier;

    public RabbitMQProducer(Supplier<Message<String>> messageSupplier) {
        this.messageSupplier = messageSupplier;
    }

    public void sendMessage(String text) {
        messageSupplier.get();
    }


}