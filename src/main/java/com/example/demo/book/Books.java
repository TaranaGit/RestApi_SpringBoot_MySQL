package com.example.demo.book;

import jakarta.persistence.*;

// mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class Books {
    //variable /field declaration
    //defining book id as primary key
    @Id
    @SequenceGenerator(
            name = "book_name",
            sequenceName = "book_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_name"
    )
    @Column
    private Integer bookId;
    @Column
    private String bookName;
    @Column
    private  String author;
    @Column
    private  int price;

    public Books() {
    }

    // constructor
    public Books(int bookId, String bookName, String author, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }
// method declaration: getter and setter using built in way; no need of code writing

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
