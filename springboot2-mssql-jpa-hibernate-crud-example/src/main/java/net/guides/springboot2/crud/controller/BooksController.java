package net.guides.springboot2.crud.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.Books;
import net.guides.springboot2.crud.repository.BookRepository;



@RestController
@RequestMapping("/api")
public class BooksController {
	 @Autowired
	    private BookRepository bookRepository;
	
	 @GetMapping("/books")
	    public List<Books> getAllBooks() {
	        return bookRepository.findAll();
	    }
	 
	 @GetMapping("/books/{id}")
	    public ResponseEntity<Books> getBooksById(@PathVariable(value = "id") long booksId)
	        throws ResourceNotFoundException {
	        Books books = bookRepository.findById(booksId)
	          .orElseThrow(() -> new ResourceNotFoundException("Books not found for this id :: " + booksId));
	        return ResponseEntity.ok().body(books);
	    }
	 @PostMapping("/books")
	    public Books createBooks(@Valid @RequestBody Books books) {
	        return bookRepository.save(books);
	    }
	 @PutMapping("/books/{id}")
	    public ResponseEntity<Books> updateBooks(@PathVariable(value = "id") long booksId,
	         @Valid @RequestBody Books booksDetails) throws ResourceNotFoundException {
	        Books books= bookRepository.findById(booksId)
	        .orElseThrow(() -> new ResourceNotFoundException("Books not found for this id :: " + booksId));

	        books.setBookAuthor(booksDetails.getBookAuthor());
	        books.setBookDescription(booksDetails.getBookDescription());
	        books.setBookImageContentType(booksDetails.getBookImageContentType());
	        books.setBookIsbn(booksDetails.getBookIsbn());
	        books.setBookPages(booksDetails.getBookPages());
	        books.setBookPrice(booksDetails.getBookPrice());
	        books.setBookTitle(booksDetails.getBookTitle());
	        final Books updatedBooks= bookRepository.save(books);
	        return ResponseEntity.ok(updatedBooks);
	    }
	 @DeleteMapping("/books/{id}")
	    public Map<String, Boolean> deleteBooks(@PathVariable(value = "id") long bookId)
	         throws ResourceNotFoundException {
	        Books book = bookRepository.findById(bookId)
	       .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

	        bookRepository.delete(book);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}

   