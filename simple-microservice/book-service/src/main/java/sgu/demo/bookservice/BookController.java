package sgu.demo.bookservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

//@RestController
        @AllArgsConstructor
//@RequestMapping("test")
public class BookController {
    private final BookRepository bookRepository;


    @GetMapping
    public String hello() {
        String instanceId = System.getenv().getOrDefault("INSTANCE_ID", "unknown");
        System.out.println("Instance ID: " + instanceId);
        return String.format("<h1>Hello from instance %s at %s</h1>", instanceId, LocalDate.now());
    }
}
