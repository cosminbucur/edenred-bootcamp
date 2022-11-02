package com.sda.cleancode.cqrs;

import java.util.List;

public interface QueryService {

    Author getAuthorByUsername(Long id);

    Book getBook(String title);

    List<Book> getAuthorBooks(String authorName);

    int getAuthorBooksCount(String authorName);

}
