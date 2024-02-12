package com.example.demo.book;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//defining the business logic
@Service
public class BooksService {
    private  final BooksRepository booksRepository;
    @Autowired
    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public  List<Books> getBooks() {
        return booksRepository.findAll(); // here return records from the conneting database
    }
    public void addNewBook(Books book){
        // this code implements that if we insert an existing book then it will throw msg'author taken'
        Optional<Books> studentOptional =
        booksRepository.findBooksByAuthor(book.getAuthor());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Author taken");
        }
        System.out.println(book);
        booksRepository.save(book);
    }

    public void deleteBook( Integer bookId){
    boolean exist =booksRepository.existsById(bookId);
    if(!exist){
        throw new IllegalStateException(
                "book id:"+ bookId + "does not exist" );
    }
    else {
    booksRepository.deleteById(bookId);
    throw  new IllegalStateException("Successfully Deleted!");
    }
    }
    @Transactional
    public void updateBook(Integer bookId, String bookName, String author){
        Books book = booksRepository.findById(bookId)
                .orElseThrow(
                        () -> new IllegalStateException(
                        "Boook id:" + bookId + "doen not exist")
                );
        System.out.println("updated book name: " +book.getBookName() + "var:" +bookName);
        if (bookName != null && bookName.length() > 0 &&
                !Objects.equals(book.getBookName(), bookName))
        {

            book.setBookName(bookName);
        }

        if (author != null && author.length() > 0 &&
                !Objects.equals(book.getAuthor(), author))
        {
            book.setAuthor(author);
        }

       booksRepository.save(book);
        System.out.println("updates are saved in DB");

    }

}















//
//    @Autowired
//    BooksRepository booksRepository;
////getting all books record by using the method findaAll() of CrudRepository
//    public List<Books>getAllBooks(){
//        List<Books> books = new ArrayList<Books>();
//        booksRepository.findAll().forEach(books1 -> books.add(books1));
//        return books;
//    }
//
//    //getting a specific record by using the method findById() of CrudRepository
//    public  Books getBooksById(int id){
//        return booksRepository.findById(id).get();
//    }
////saving a specific record by using the method save() of CrudRepository
//    public void saveOrUpdate(Books books){
//        booksRepository.save(books);
//    }
//    //deleting a specific record by using the method deleteById() of CrudRepository
//    public void delete(int id)
//    {
//        booksRepository.deleteById(id);
//    }
//    //updating a record
//    public void update(Books books, int bookId)
//    {
//        booksRepository.save(books);
//    }



