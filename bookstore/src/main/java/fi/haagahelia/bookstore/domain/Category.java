package fi.haagahelia.bookstore.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long catId;
    private String catName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books; 

   
    public Category(){

    }

    public Category(String catName) {
        
        this.catName = catName;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public Long getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }


}
