package sgu.demo.authorservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final BookClient bookClient;

    public BookService(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @CircuitBreaker(name = "bookService", fallbackMethod = "fallbackGetBook")
    public List<Object> getBookByAuthorId(Long id) {
        return bookClient.getBookByAuthorId(id);
    }

    public List<Object>  fallbackGetBook(Long id, Throwable t) {
        System.out.println("Fallback triggered due to: " + t.getMessage());
        return List.of( Map.of("message", "Fallback triggered due to: " + t.getMessage()));
    }
}
