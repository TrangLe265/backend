package fi.haagahelia.bookstore.domain;

import java.util.List;

import jakarta.persistence.*; 

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
        super();   
        this.catName = catName;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setCatId(Long catId){
        this.catId = catId; 
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

    @Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + "]";
	}

}
