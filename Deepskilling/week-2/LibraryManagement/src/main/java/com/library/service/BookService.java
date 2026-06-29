package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    // Constructor Injection managed by Spring IoC
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        List<String> books = bookRepository.getAvailableBooks();
        System.out.println("--- Library Inventory ---");
        books.forEach(book -> System.out.println("- " + book));
    }
}
