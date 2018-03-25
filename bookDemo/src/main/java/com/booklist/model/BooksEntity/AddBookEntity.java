package com.booklist.model.BooksEntity;

/**
 * Created by chen on 2018/3/25.
 */
public class AddBookEntity {
    private String bookName;
    private String author;
    private Double price;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
