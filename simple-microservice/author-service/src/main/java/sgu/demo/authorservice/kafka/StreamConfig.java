package sgu.demo.authorservice.kafka;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.function.context.FunctionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sgu.demo.authorservice.AuthorRepository;

@Configuration
@Slf4j
public class StreamConfig {


    @Bean
    public Consumer<Map<String, Object>> consumeMessage(AuthorRepository repository) {
        return message -> {
            if(message.get("eventType").equals("created")) {
                log.info("A book was created, incrementing author's book count");
                Map<String,Object> book = (Map<String, Object>) message.get("data");
                Integer authorId = (Integer) book.get("authorId");
                repository.incrementBookCount(authorId);
            }
            log.info("Consumer started and waiting for messages...");
            log.info("Received message: {}", message);
        };
    }



    @PostConstruct
    public void init() {
        log.info("Stream configuration initialized");
    }
}