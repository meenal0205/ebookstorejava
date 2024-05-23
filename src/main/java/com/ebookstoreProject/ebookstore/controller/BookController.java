package com.ebookstoreProject.ebookstore.controller;

import com.ebookstoreProject.ebookstore.model.Book;
import com.ebookstoreProject.ebookstore.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:3000/")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){ return bookService.createBookEntity(book);}

    @GetMapping("/books")
    public List<Book> getAllBooks() {return bookService.getAllBookEntity();}

    @GetMapping("/books/{Id}")
    public ResponseEntity<Book> getBookByID(@PathVariable Integer Id){
        Book book = null;
        book=bookService.getBookEntityById(Id);
        return ResponseEntity.ok(book);
    }
    @PutMapping("/books/{Id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer Id,@RequestBody Book book){
        book=bookService.updateBookEntity(Id,book);
        return ResponseEntity.ok(book);

    }
    @DeleteMapping("/books/{Id}")
    public ResponseEntity<Map<String,Boolean>> deleteBook(@PathVariable Integer Id){
        boolean deleted=false;
        deleted=bookService.deleteBookEntity(Id);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }
}
