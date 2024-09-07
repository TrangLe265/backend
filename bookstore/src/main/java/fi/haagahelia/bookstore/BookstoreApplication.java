package fi.haagahelia.bookstore;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);
	private final BookRepository repository; 
	private final CategoryRepository catRepo; 

	public BookstoreApplication(BookRepository repository, CategoryRepository catRepo){
		this.repository = repository; 
		this.catRepo = catRepo; 
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Override
	public void run(String...args) throws Exception{
		Category category1 = new Category("fiction"); 
		Category category2 = new Category("education"); 
		catRepo.saveAll(Arrays.asList(category1,category2)); 
		
        	List<Book> books = Arrays.asList(
            new Book("Effective Java", "Joshua Bloch", 2018, 9780134685991L, 45.00f, category1),
            new Book("Head First Java", "Kathy Sierra", 2005, 9780596009205L, 39.99f, category2),
            new Book("Clean Code", "Robert C. Martin", 2008, 9780132350884L, 49.99f,category2),
            new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 9780321356680L, 59.99f, category2)
        );
        // Save books to the database
        repository.saveAll(books);
    }

}
