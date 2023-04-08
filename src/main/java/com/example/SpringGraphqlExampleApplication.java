package com.example;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGraphqlExampleApplication  implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setTitle("complete reference");
		b1.setDesc("fro learning java");
		b1.setPages(2000);
		b1.setPrice(5000);
		b1.setAuthor("XYZ");

		Book b2 = new Book();
		b2.setTitle("Python Example 4");
		b2.setDesc("python project based book");
		b2.setPages(540);
		b2.setPrice(2500);
		b2.setAuthor("Anotmal");

		Book b3 = new Book();
		b3.setTitle("Head First to java");
		b3.setDesc("For starting java concept");
		b3.setPages(1000);
		b3.setPrice(2000);
		b3.setAuthor("Eric");

		this.bookService.crate(b1);
		this.bookService.crate(b2);
		this.bookService.crate(b3);

	}
}
