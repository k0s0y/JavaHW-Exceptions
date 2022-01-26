package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldHaveAllMethodsFromParent() {
        Book book = new Book();
    }

    @Test
    public void shouldUseEquals() {
        Book book1 = new Book(1, "CoolBook", 300, "CoolAuthor");
        Book book2 = new Book(1, "CoolBook", 300, "CoolAuthor");

        assertEquals(book1, book2);
    }

    @Test
    public void shouldInstallAuthor() {
        Book book = new Book(null);
        book.setAuthor("Name");
        String expected = "Name";
        String actual = book.getAuthor();
        assertEquals(expected, actual);
    }

}