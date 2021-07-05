package com.api.book.bookrestbook.controllers;


import com.api.book.bookrestbook.entities.Book;
import com.api.book.bookrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){

        List<Book> list = this.bookService.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }
    
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id)
    {
        Book book = bookService.getBookById(id);
        if (book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }
    
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book ) {
        Book b = null;
        try {
             b = this.bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).build();
        }

    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }
    
    //update book handler
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }
    
}
