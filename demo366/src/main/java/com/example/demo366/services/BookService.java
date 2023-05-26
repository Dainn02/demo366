package com.example.demo366.services;

import com.example.demo366.entity.Book;
import com.example.demo366.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void updateBook(Book book){ bookRepository.save(book);}
    public void deleteBook(Long id){bookRepository.deleteById(id);}
}
