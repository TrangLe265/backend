package fi.haagahelia.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends CrudRepository<Book,Long>{
//BookRepository an interface extending one of Spring Data's repository interfaces
//It provides data access methods such as findAll(), saveAll
//<Book,Long> : meaning this is a repository for the Book class and the ID type is long

    List<Book> findByTitle(String title); 
}
