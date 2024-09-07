package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@Controller
public class BookController {
    
    //allows Spring to automatically inject an instance of BookRepository into the BookController.
    @Autowired 
    private BookRepository repository;
    
    @RequestMapping(value={"/","/booklist"})
    public String bookList(Model model){ //the attribute name here have to match the collection name in the html <tr th:each = "book : ${books}">
        model.addAttribute("books",repository.findAll()); 
        //findAll = retrieves a list of all books from the database.
        return "booklist"; 
    }

    //adding and saving new book start here
    @RequestMapping(value = {"/add"}) //this display the form to add new book
    public String addBook(Model model){
        model.addAttribute("book", new Book()); 
        return "addbook"; 
    }

    @RequestMapping(value={"/save"}, method = RequestMethod.POST) //this takes care of adding the book
    public String save(Book book){
        System.out.println("SAVING BOOK");
        repository.save(book); 
        return "redirect:/booklist"; 
    }
    // end here

    @RequestMapping(value="/delete/{isbn}", method= RequestMethod.GET)
    public String deleteBook(@PathVariable("isbn") Long isbn, Model model){
        repository.deleteById(isbn);
        return "redirect:../booklist"; 
    }

    @RequestMapping(value = "/edit/{isbn}", method = RequestMethod.GET)
    public String showEditBook(@PathVariable("isbn") Long isbn, Model model){
        model.addAttribute("book", repository.findById(isbn));
        model.addAttribute("books", repository.findAll()); 
        return "editbook"; 
    }
}
