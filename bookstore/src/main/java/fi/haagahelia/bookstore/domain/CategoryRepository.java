package fi.haagahelia.bookstore.domain;
import org.springframework.data.repository.CrudRepository;
public interface CategoryRepository extends CrudRepository<Category,Long > {
    //<Class name, Primary key of the class>
}
