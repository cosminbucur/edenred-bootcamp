package com.sda.cleancode.cqrs;

public interface CommandService {

    Author getAuthorById(Long id);

    Book getBookByTitle(String title);

    void authorCreated(String name, int age);

    void authorNameUpdated(String newName);

}
