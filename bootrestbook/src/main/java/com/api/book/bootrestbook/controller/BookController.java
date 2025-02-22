package com.api.book.bootrestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookServices;

@RestController
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return this.bookServices.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id){
        return this.bookServices.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b= this.bookServices.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{bId}")
    public void deleteBook(@PathVariable("bId") int id){
        this.bookServices.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book ,@PathVariable("id") int id){
        this.bookServices.updateBook(book, id);
        return book;
    }
}



// // @Controller
// @RestController
// public class BookController {
//     // @RequestMapping(value = "/book", method = RequestMethod.GET)
//     // @ResponseBody
//     @GetMapping("/book")
//     public String book(){
//         return "this is a book testing.";
//     }
// }

// @RestController
// public class BookController {

//     @GetMapping("/book")
//     public Book getBook(){
//         Book b = new Book();
//         b.setId(10);
//         b.setName("JAVA");
//         b.setAuthor("James Gosling");
//         return b;
//     }
// }
