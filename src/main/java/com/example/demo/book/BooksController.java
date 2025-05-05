package com.example.demo.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// mark class as Controller
@RestController
@RequestMapping(path = {"api/books"})
public class BooksController {
  private  final BooksService booksService;
@Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @GetMapping
    public List<Books> getBooks(){
        return booksService.getBooks(); // In this code we are returning value to webbrowser
    }
    @PostMapping
    public void registerNewBook(@RequestBody Books book){
    booksService.addNewBook(book);
    }
    @DeleteMapping(path = "{bookId}")
    public  void deleteBook(@PathVariable("bookId") Integer bookId){
    booksService.deleteBook(bookId);
    }
    @PutMapping(path= "{bookId}")
    public void updateStudent(
            @PathVariable("bookId") Integer bookId,
            @RequestBody Books book)
    {
        System.out.println("book name in Controller:" + book.getBookName());

    booksService.updateBook(bookId,book.getBookName(),book.getAuthor());
    }














