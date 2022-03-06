package com.example.mortgageservice.service;

import com.example.mortgageservice.model.Book;
import com.example.mortgageservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }
}
