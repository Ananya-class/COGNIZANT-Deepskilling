package com.library.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    public List<String> getAvailableBooks() {
        return Arrays.asList("Clean Code", "Effective Java", "Spring in Action");
    }
}
