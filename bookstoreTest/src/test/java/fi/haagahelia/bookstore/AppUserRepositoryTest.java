package fi.haagahelia.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.bookstore.domain.AppUser;
import fi.haagahelia.bookstore.domain.AppUserRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppUserRepositoryTest {
    @Autowired
    private AppUserRepository uRepository; 

    @Test
    public void findByUserName(){
        List<AppUser> users = uRepository.findByUsername("user"); 

        assertThat(users).hasSize(1); 
        assertThat(users.get(0).getUsername()).isEqualTo("user");
    }

    @Test
    public void addUser(){
        AppUser user = new AppUser("userno1","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","ROLE_USER"); 
        uRepository.save(user); 
        assertThat(user.getId()).isNotNull(); 
    }

    @Test
    public void deleteUser(){
        List<AppUser> users = uRepository.findByUsername("user"); 
        AppUser newUser = users.get(0); 
        uRepository.delete(newUser);
        List<AppUser> newUsers = uRepository.findByUsername("user"); 
        assertThat(newUsers).hasSize(0); 

    }


}
