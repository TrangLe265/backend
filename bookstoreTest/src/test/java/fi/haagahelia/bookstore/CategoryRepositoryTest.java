package fi.haagahelia.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
    
    @Autowired
    private CategoryRepository cRepository; 

    @Test
    public void findByCatName(){
        List<Category> categories = cRepository.findByCatName("fiction"); 
        
        assertThat(categories).hasSize(1); 
        assertThat(categories.get(0).getCatName()).isEqualTo("fiction"); 
    }

    @Test
    public void createCategory(){
        Category category = new Category(); 
        cRepository.save(category); 
        assertThat(category.getCatId()).isNotNull();  
    }

    @Test
    public void deleteCategory(){
        List<Category> categories = cRepository.findByCatName("fiction"); 
        Category category = categories.get(0); 
        cRepository.delete(category);
        List<Category> newCategories = cRepository.findByCatName("fiction"); 
        assertThat(newCategories).hasSize(0); 
    }

    
}
