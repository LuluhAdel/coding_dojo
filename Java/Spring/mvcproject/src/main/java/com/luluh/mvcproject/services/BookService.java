package com.luluh.mvcproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luluh.mvcproject.models.Book;
import com.luluh.mvcproject.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    //update a book

	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		  if(optionalBook.isPresent()) {
			  Book optionalBook1 = optionalBook.get();
			  optionalBook1.setTitle(title);
			  optionalBook1.setDescription(desc);
			  optionalBook1.setLanguage(lang);
			  optionalBook1.setPages(numOfPages);
			  return bookRepository.save(optionalBook1);   
	        } else {
	            return null;
	        }
		
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}


}
