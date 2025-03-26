package sgu.demo.bookservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource()
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAllByAuthorId(Long id);
}
