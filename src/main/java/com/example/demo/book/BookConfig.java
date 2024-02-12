package com.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BooksRepository repository){
        return args -> {
           Books b1 = new Books(1, "Wind of ocean!!!",
                                  "patterson", 2);

            Books b2 = new Books(2, "water of river!!!",
                    "jason", 10);
            repository.saveAll(List.of(b1,b2));

        };
    }
}
