package com.sunwx.springbootrabbitmq.bean;

import java.io.Serializable;

public class Books implements Serializable {
    private int book_id;
    private String book_name;
    private String book_author;

    public Books(int book_id, String book_name, String book_author) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
    }

    public Books() {
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                '}';
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }
}
