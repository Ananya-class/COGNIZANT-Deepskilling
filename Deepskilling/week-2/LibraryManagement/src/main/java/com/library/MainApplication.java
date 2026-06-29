package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

    public static void main(String[] args) {
        // 1. Load the Spring application context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Retrieve the BookService bean managed by the IoC container
        BookService bookService = context.getBean("bookService", BookService.class);

        // 3. Execute backend business operations
        bookService.displayBooks();
    }
}
