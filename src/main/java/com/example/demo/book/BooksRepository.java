package com.example.demo.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // for accessing data from database
public interface BooksRepository extends JpaRepository<Books, Integer> {

    @Query("SELECT b FROM Books b WHERE b.author = ?1")
    Optional<Books> findBooksByAuthor(String author);
}

