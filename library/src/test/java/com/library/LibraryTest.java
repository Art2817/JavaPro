package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    void addBook_shouldIncreaseCount() {
        Library lib = new Library();
        Book book = new Book("Origin", "Dan Brown");
        lib.addBook(book);
        assertEquals(1, lib.getBookCount());
        assertTrue(lib.getBooks().contains(book));
    }

    @Test
    void addBook_null_shouldThrow() {
        Library lib = new Library();
        assertThrows(IllegalArgumentException.class, () -> lib.addBook(null));
    }

    @Test
    void removeBook_existing_shouldReturnTrue() {
        Library lib = new Library();
        Book book = new Book("Origin", "Dan Brown");
        lib.addBook(book);
        boolean result = lib.removeBook(book);
        assertTrue(result);
        assertEquals(0, lib.getBookCount());
    }

    @Test
    void removeBook_notExisting_shouldReturnFalse() {
        Library lib = new Library();
        Book book = new Book("Origin", "Dan Brown");
        assertFalse(lib.removeBook(book));
    }

    @Test
    void removeBook_null_shouldReturnFalse() {
        Library lib = new Library();
        assertFalse(lib.removeBook(null));
    }

    @Test
    void getBooks_shouldBeUnmodifiable() {
        Library lib = new Library();
        lib.addBook(new Book("Origin", "Dan Brown"));
        assertThrows(UnsupportedOperationException.class,
                () -> lib.getBooks().add(new Book("Test", "Test")));
    }

    @Test
    void book_equals_hashCode_shouldWork() {
        Book b1 = new Book("Origin", "Dan Brown");
        Book b2 = new Book("Origin", "Dan Brown");

        assertEquals(b1, b2);
        assertEquals(b1.hashCode(), b2.hashCode());
    }

    @Test
    void book_toString_shouldContainFields() {
        Book b = new Book("Origin", "Dan Brown");
        String str = b.toString();
        assertTrue(str.contains("Origin"));
        assertTrue(str.contains("Dan Brown"));
    }
}