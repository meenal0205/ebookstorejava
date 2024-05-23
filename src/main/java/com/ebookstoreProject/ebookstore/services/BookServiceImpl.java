package com.ebookstoreProject.ebookstore.services;

import com.ebookstoreProject.ebookstore.Repository.BookRepository;
import com.ebookstoreProject.ebookstore.entity.BookEntity;
import com.ebookstoreProject.ebookstore.model.Book;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {this.bookRepository=bookRepository;}


    @Override
    public Book createBookEntity(Book book) {
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(book,bookEntity);
        bookRepository.save(bookEntity);
        return book;
    }

    @Override
    public boolean deleteBookEntity(Integer Id) {
        BookEntity bookEntity= bookRepository.findById(Id).get();
        bookRepository.delete(bookEntity);
        return true;

    }

    @Override
    public List<Book> getAllBookEntity() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<Book> books=bookEntities
                .stream()
                .map(book->new Book(
                        book.getId(),
                        book.getName(),
                        book.getAuthor(),
                        book.getGenre(),
                        book.getDescription(),
                        book.getStock(),
                        book.getPrice(),
                        book.getBookurl()))
        .collect(Collectors.toList());
        return books;
    }

    @Override
    public Book getBookEntityById(Integer Id) {
        BookEntity bookEntity = bookRepository.findById(Id).get();
        Book book= new Book();
        BeanUtils.copyProperties(bookEntity,book);
        return book;
    }

    @Override
    public Book updateBookEntity(Integer Id, Book book) {

        BookEntity bookEntity = bookRepository.findById(Id).get();
        bookEntity.setName(book.getName());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setGenre((book.getGenre()));
        bookEntity.setStock(book.getStock());
        bookEntity.setBookurl(book.getBookurl());
        bookEntity.setDescription(book.getDescription());
        bookRepository.save(bookEntity);
        return book;
    }
    @Override
    public Integer purchaseBook(Integer id2, Book book,Integer amount) {
        BookEntity bookEntity=bookRepository.findById(id2).get();
        if(book.getStock()-amount<0){
            return -1;
        }
        else{
            bookEntity.setStock(book.getStock()-amount);
            bookRepository.save(bookEntity);
            return 1;
        }
    }


}
