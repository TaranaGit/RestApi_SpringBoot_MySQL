package com.example.demo;

//import com.example.demo.student.Student;
import com.example.demo.book.Books;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
//	@GetMapping("/hello")
//	public List<Books> hello(){
//
//
////		Books book = new Books(1, "Wind of ocean!!!", "patterson", 2);
//// 		List<Books> booklist = List.of(book);
////		return List.of(book);
//
////		return  "Hello, World!!!!!";
////		return List.of(new Books(1, "Wind of ocean", "patterson", 2));
//	}
}

//previous code:
