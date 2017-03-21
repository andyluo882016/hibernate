package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Book;
import com.example.domain.Publisher;
import com.example.repository.BookRepository;
import com.example.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;

@SpringBootApplication
public class SpringHibernateMySqlApplication implements CommandLineRunner {

	 private static final Logger logger = LoggerFactory.getLogger(SpringHibernateMySqlApplication.class);
	 
	 @Autowired
	    private BookRepository bookRepository;

	    @Autowired
	    private PublisherRepository publisherRepository;
	 
    	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateMySqlApplication.class, args);
    	}
		

		    @Override
		    @Transactional
		    public void run(String... strings) throws Exception {
		        // save a couple of books
		        Publisher publisherA = new Publisher("Publisher A");
		        Publisher publisherB = new Publisher("Publisher B");
		        Publisher publisherC = new Publisher("Publisher C");

		        bookRepository.save(new HashSet<Book>(){/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

				{
		            add(new Book("Book A", new HashSet<Publisher>(){/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

					{
		                add(publisherA);
		                add(publisherB);
		            }})
		            		);

		            add(new Book("Book B", new HashSet<Publisher>(){/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

					{
		                add(publisherA);
		                add(publisherC);
		            }}));
		        }});

		        // fetch all books
		        for(Book book : bookRepository.findAll()) {
		            logger.info(book.toString());
		        }

		        // save a couple of publishers
		        Book bookA = new Book("Book A");
		        Book bookB = new Book("Book B");

		        publisherRepository.save(new HashSet<Publisher>() {/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

				{
		            add(new Publisher("Publisher A", new HashSet<Book>() {/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

					{
		                add(bookA);
		                add(bookB);
		            }}));

		            add(new Publisher("Publisher B", new HashSet<Book>() {/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

					{
		                add(bookA);
		                add(bookB);
		            }}));
		        }});

		        // fetch all publishers
		        for(Publisher publisher : publisherRepository.findAll()) {
		            logger.info(publisher.toString());
		        }
		    }
		
		
	
}
