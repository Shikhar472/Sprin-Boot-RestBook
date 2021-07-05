package com.api.book.bookrestbook.dao;

import com.api.book.bookrestbook.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
