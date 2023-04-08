package com.example;

import com.example.entity.Book;
import com.example.entity.Laptop;
import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringGraphqlExampleApplication  implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringGraphqlExampleApplication.class);
	@Autowired
	private BookService bookService;

	@Autowired
	private StudentRepository studentRepository;

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


		// create student and laptop
		// one to one mapp
		Student student = new Student();
		student.setStudentName("kumar");
		student.setAbout("software engineer");
		student.setStudentId(12);

		// mapped by foreign key
		Laptop laptop = new Laptop();
		laptop.setModelNumber("123");
		laptop.setBrand("Dell");
		laptop.setLaptopId(1233);

		// important
		laptop.setStudent(student);
		// manually laptop save
		// laptop repository

		student.setLaptop(laptop);

		Student save = studentRepository.save(student);
		logger.info("saved student: {}", save.getStudentName());

		Student student1 = studentRepository.findById(12).get();
		logger.info("Name is {}", student1.getStudentName());

		Laptop laptop1 = student1.getLaptop();
		logger.info("Laptop {}, {}",laptop1.getBrand(), laptop1.getModelNumber());
	}
}
