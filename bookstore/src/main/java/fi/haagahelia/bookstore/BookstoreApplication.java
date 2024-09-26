package fi.haagahelia.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository catRepo) {
		return (args) -> {
			log.info("save a couple of students");
			catRepo.save(new Category("fiction"));
			catRepo.save(new Category("education")); 

			repository.save(new Book("Effective Java", "Joshua Bloch", 2018, "9780134685991", 45.00f, catRepo.findByCatName("fiction").get(0))); 
			repository.save(new Book("Head First Java", "Kathy Sierra", 2005, "9780596009205", 39.99f, catRepo.findByCatName("fiction").get(0))); 
			
			for (Book book : repository.findAll()){
				log.info(book.toString()); 
			}
	}; 
    }

}