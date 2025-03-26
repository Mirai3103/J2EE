package sgu.demo.authorservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "book-service")
public interface BookClient {
    @GetMapping("/api/books/author/{id}")
    List<Object> getBookByAuthorId(@PathVariable("id") Long id);
}
