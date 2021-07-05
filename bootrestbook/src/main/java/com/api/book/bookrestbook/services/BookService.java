package com.api.book.bookrestbook.services;

import com.api.book.bookrestbook.dao.BookRepository;
import com.api.book.bookrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

//    private static List<Book> list = new ArrayList<>();
//
//    static {
//        list.add(new Book(12,"Java Complete Reference", "XYZ"));
//        list.add(new Book(13,"Python Complete Reference", "ABC"));
//        list.add(new Book(14,"Ruby Complete Reference", "GAGS"));
//    }

    //get all books

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){

        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        try {
            //book = list.stream().filter(e->e.getId()==id).findFirst().get();
            book = this.bookRepository.findById(id);

        } catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }
    //adding the book
    public Book addBook(Book book){
       Book book1 =  this.bookRepository.save(book);
        return book1;
    }

    //delete book

    public void deleteBook(int bid){

        bookRepository.deleteById(bid);
    }

    //update the book
    public void updateBook(Book book,int bookId){

        book.setId(bookId);
        bookRepository.save(book);
    }
}
