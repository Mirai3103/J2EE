package sgu.demo.bookservice;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@RestController
        @RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;


    @Value("${app.version:none}")
    private String version;


    @GetMapping("test")
    public String hello() {
        String instanceId = System.getenv().getOrDefault("INSTANCE_ID", "unknown");
        System.out.println("Instance ID: " + instanceId);
        return String.format("<h1>Hello from Books instance %s at %s version %s</h1>", instanceId, LocalDate.now(), version);
    }
    @GetMapping("/author/{id}")
    public List<Book> getBookByAuthorId(@PathVariable String id) {
        seed();
        Long authorId = Long.parseLong(id);
        // ti le 70% la throw exception
        if (Math.random() < 0.8 ) {
            throw new RuntimeException("Error from Book service");
        }
        return bookRepository.findAllByAuthorId(authorId);
    }

    private void seed(){
        if (bookRepository.count() != 0) {
            return;
        }
        Faker faker = new Faker();
        int[] authorIds = {1, 2, 3, 4, 5};
        for (int i = 0; i < 50; i++) {
            Book book = Book.builder()
                    .title(faker.book().title())
                    .authorId((long) authorIds[i % authorIds.length])
                    .year(faker.number().numberBetween(1900, 2021))
                    .build();
            bookRepository.save(book);
        }
    }
}
