package sgu.demo.authorservice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource()
public interface AuthorRepository extends org.springframework.data.repository.CrudRepository<Author, Integer> {
    @Modifying
    @Query(value = "UPDATE author SET book_count = book_count + 1 WHERE id = ?1", nativeQuery = true)
    void incrementBookCount(Integer authorId);
}
