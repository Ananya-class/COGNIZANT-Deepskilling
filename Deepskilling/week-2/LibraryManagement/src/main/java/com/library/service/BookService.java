package com.library.service;

import java.util.List;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // The setter method Spring uses to inject the BookRepository bean
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("Fetching catalog from repository...");

        // Calling the method from the injected dependency
        List<String> books = bookRepository.getAvailableBooks();

        for (String book : books) {
            System.out.println("- " + book);
        }
    }
}
