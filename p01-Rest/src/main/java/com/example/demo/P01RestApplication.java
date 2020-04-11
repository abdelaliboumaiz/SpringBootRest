package com.example.demo;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.BookRepository;
import com.example.demo.models.Book;

@SpringBootApplication
public class P01RestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(P01RestApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		Stream.of(
				new Book("Book A", LocalDate.of(2000, 5, 22), 150),
				new Book("Book B", LocalDate.of(1922, 11, 22), 300),
				new Book("Book C", LocalDate.of(1922, 11, 22), 450)
				).forEach(s -> bookRepository.save(s));
		bookRepository.findAll().forEach(b -> System.out.println(b));
	}
}




