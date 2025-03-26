package sgu.demo.authorservice;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Slf4j
public class AuthorController {
    private final BookClient bookClient;
    private final BookService bookService;
    private final AuthorRepository repository;
    private final StreamBridge streamBridge;

    @GetMapping
    public Map<String, String> hello() {
        String instanceId = System.getenv().getOrDefault("INSTANCE_ID", "unknown");
        System.out.println("Instance ID: " + instanceId);
//        return String.format("<h1>Hello from Author instance %s at %s</h1>", instanceId, java.time.LocalDate.now());?
        return Map.of("instanceId", instanceId, "time", java.time.LocalDate.now().toString(), "message", "Hello from Author instance");
    }

    @GetMapping("{id}")
    public Map<String, Object> getAuthorById(@PathVariable String id) {
        seed();
        var author = repository.findById((int) Long.parseLong(id)).orElseThrow();
        var book = bookService.getBookByAuthorId(Long.parseLong(id));
        return Map.of("author", author, "bookCount", book.size(), "books", book);
    }
    @GetMapping("/all")
    public Map<String, Object> getAllAuthors() {
        String message ="Hello from producer " + System.currentTimeMillis();
        streamBridge.send("produceMessage-out-0", message);
        var authors = repository.findAll();
        return Map.of("authors", authors);
    }

    private void seed() {
        if (repository.count() != 0) {
            return;
        }
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Author author = Author.builder()
                    .address(faker.address().fullAddress())
                    .email(faker.internet().emailAddress())
                    .name(faker.name().fullName())
                    .id((long) (i + 1))
                    .build();
            repository.save(author);
        }

    }

//    @KafkaListener(topics = "output-topic", groupId = "my-consumer-group")
//    public void consume(GenericMessage<String> message) {
//        log.info("Received message via KafkaListener: {}", message.getPayload());
//    }


}
