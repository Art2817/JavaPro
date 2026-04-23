package com.library;

import java.util.Objects;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        setTitle(title);
        setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        this.author = author;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Book))
            return false;

        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }

    public int hashCode() {
        return Objects.hash(title, author);
    }

    public String toString() {
        return "Book{" + "title='" + title + '\n' + ", author='" + author + '\n' + '}';
    }
}