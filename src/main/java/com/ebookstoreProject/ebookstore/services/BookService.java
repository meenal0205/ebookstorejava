package com.ebookstoreProject.ebookstore.services;

import com.ebookstoreProject.ebookstore.entity.BookEntity;
import com.ebookstoreProject.ebookstore.model.Book;

import org.springframework.stereotype.Service;


import java.util.List;

public interface BookService {
    Book createBookEntity(Book book);
    boolean deleteBookEntity(Integer Id);
   List<Book> getAllBookEntity();
    Book getBookEntityById(Integer Id);
    Book updateBookEntity(Integer Id, Book book);


    Integer purchaseBook(Integer id2, Book book,Integer amount);
}
