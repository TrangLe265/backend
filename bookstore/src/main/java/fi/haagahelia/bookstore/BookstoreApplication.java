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

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);
	private final BookRepository repository; 

	public BookstoreApplication(BookRepository repository){
		this.repository = repository; 
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Override
	public void run(String...args) throws Exception{
		
        	List<Book> books = Arrays.asList(
            new Book("Effective Java", "Joshua Bloch", 2018, 9780134685991L, 45.00f),
            new Book("Head First Java", "Kathy Sierra", 2005, 9780596009205L, 39.99f),
            new Book("Clean Code", "Robert C. Martin", 2008, 9780132350884L, 49.99f),
            new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 9780321356680L, 59.99f)
        );
        // Save books to the database
        repository.saveAll(books);
    }

}
