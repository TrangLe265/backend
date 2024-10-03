package fi.haagahelia.bookstore;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import fi.haagahelia.bookstore.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Autowired
	private UserDetailServiceImpl userDetailsService;

	private static final AntPathRequestMatcher[] WHITE_LIST_URLS = { 
			new AntPathRequestMatcher("/api/students**"),
			new AntPathRequestMatcher("/h2-console/**") };


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
       
        http  //defines which URL paths are secured
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(antMatcher("/css/**")).permitAll()//enable CSS when logged out //the oath configured here do not need authentication
                .requestMatchers(WHITE_LIST_URLS).permitAll()
                .anyRequest().authenticated())
                .headers(headers -> 
                headers.frameOptions(frameOptions -> frameOptions
                    .disable()))
            .formLogin(formlogin -> formlogin.loginPage("/login")
                .defaultSuccessUrl("/booklist", true).permitAll() //after successful login, go to this URL
            ).logout(logout -> logout
                .permitAll())
            .csrf(csrf -> csrf.disable());
            return http.build(); 

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); 
    }

    /*@Bean
    public UserDetailsService userDetailsService() {
        //Creating default users
        System.out.println("in memory users");
        List<UserDetails> users = new ArrayList<UserDetails>(); 

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user1 = User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build();

        users.add(user1);

        UserDetails user2 = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build();

        users.add(user2);

        return new InMemoryUserDetailsManager(users); 

    } */

}
