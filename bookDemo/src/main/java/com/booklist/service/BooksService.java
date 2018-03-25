package com.booklist.service;

import com.booklist.model.BooksEntity.AddBookEntity;
import com.booklist.model.BooksEntity.BooksEntity;
import com.booklist.model.BooksJson.BooksJson;

import java.util.List;

/**
 * Created by chen on 2018/3/24.
 */
public interface BooksService {
    //查所有书列表
    List<BooksJson> queryAllBooks();

    boolean addBook(AddBookEntity addBookEntity);

    boolean deleteBookById(int id);

    boolean updateBookById(BooksEntity booksEntity);

    BooksJson queryBookById(int id);
}
