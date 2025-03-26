package sgu.demo.authorservice;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class RabbitMQConsumer {
    @Bean
    public Consumer<Map<String, Object>> processMessage() {
        return message -> System.out.println("Received: " + message);
    }
    @Bean
    public Supplier<Message<String>> processMessage2() {
        return () -> MessageBuilder.withPayload("Hello from Producer").build();
    }
}
