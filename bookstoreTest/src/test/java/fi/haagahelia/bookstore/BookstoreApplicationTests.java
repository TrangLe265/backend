package fi.haagahelia.bookstore;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import fi.haagahelia.bookstore.web.BookController;

@SpringBootTest
public class BookstoreApplicationTests {
	@Autowired 
	private BookController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
