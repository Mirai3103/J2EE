package sgu.demo.authorservice;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource()
public interface AuthorRepository extends org.springframework.data.repository.CrudRepository<Author, Integer> {

}
