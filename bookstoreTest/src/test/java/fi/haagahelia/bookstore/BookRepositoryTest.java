package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bRepository; 
    @Autowired
    private CategoryRepository cRepository; 

    @Test
    public void findByTitle() {
        List<Book> books = bRepository.findByTitle("Effective Java"); 

        assertThat(books).hasSize(1); 
        assertThat(books.get(0).getTitle()).isEqualTo("Effective Java"); 
    }

    @Test
    public void createNewBook(){
        Category category = new Category("fairytale"); 
        cRepository.save(category); 
        Book book = new Book("The Litle Mermaid", "Wes Anderson", 2010, "132412941294", 45.9f, category); 
        bRepository.save(book); 
        assertThat(book.getId()).isNotNull(); 
    }

    @Test
    public void deleteBook(){
        List<Book> books = bRepository.findByTitle("Effective Java"); 
        Book book = books.get(0); 
        bRepository.delete(book);
        List<Book> newBooks = bRepository.findByTitle("Effective Java");
        assertThat(newBooks).hasSize(0); 
    }

}
