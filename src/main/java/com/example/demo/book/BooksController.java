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













    //autowired the BookService class
//    @Autowired
//    BooksService booksService; // aggregation concept
//    //creating a get mapping that retrieves all the books detail from the database
//    @GetMapping("/book")
//    private List<Books>getAllBooks(){
//        return booksService.getAllBooks();
//    }
//    //creating a get mapping that retrieves the detail of a specific book
//    @GetMapping("/book/{bookid}")
//    private Books getBooks(@PathVariable("bookid")int bookid){
//        return  booksService.getBooksById(bookid);
//    }
//    //creating a delete mapping that deletes a specified book
//    @DeleteMapping("/book/{bookid}")
//    private void deleteBook(@PathVariable("bookid") int bookid){
//        booksService.delete(bookid);
//    }
//
//    //creating post mapping that post the book detail in the database
//    @PostMapping("/books")
//    private  int saveBook(@RequestBody Books books){
//        booksService.saveOrUpdate(books);
//        return books.getBookId();
//    }
//    ////creating put mapping that updates the book detail
//    @PutMapping("/books")
//    private Books update(@RequestBody Books books){
//        booksService.saveOrUpdate(books);
//        return books;
//    }

}
