package fi.haagahelia.bookstore.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
   
    @Id //aka primary key
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String title; 
    private String author;
    private int publicationYear; 
    private float price ; 
    @ManyToOne
    private Category category; 

    
    //catergory one to many to book
    //book many to one to category

    public Book(){
        
    }
   

    public Book(String title, String author, int publicationYear, String isbn, float price,Category category) {
        super(); 
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category; 
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
	public String toString() {
		if (this.category != null)
			return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + " category=" + this.getCategory() + "]";				
		else
			return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear +  "]";	
    }
}
