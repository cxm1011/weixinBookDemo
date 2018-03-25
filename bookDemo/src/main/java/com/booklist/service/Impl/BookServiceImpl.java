package com.booklist.service.Impl;

import com.booklist.mapper.BooksMapper;
import com.booklist.model.BooksEntity.AddBookEntity;
import com.booklist.model.BooksEntity.BooksEntity;
import com.booklist.model.BooksJson.BooksJson;
import com.booklist.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chen on 2018/3/24.
 */
@Service
public class BookServiceImpl implements BooksService {
    @Autowired
    private BooksMapper booksMapper;

    @Override
    public List<BooksJson> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }

    @Override
    public boolean addBook(AddBookEntity addBookEntity) {
        try {
            booksMapper.addBook(addBookEntity);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteBookById(int id) {
        try {
            booksMapper.deleteBookById(id);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBookById(BooksEntity booksEntity) {
        try {
            booksMapper.updateBookById(booksEntity);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public BooksJson queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }
}
