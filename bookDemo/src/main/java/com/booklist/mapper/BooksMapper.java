package com.booklist.mapper;

import com.booklist.model.BooksEntity.AddBookEntity;
import com.booklist.model.BooksEntity.BooksEntity;
import com.booklist.model.BooksJson.BooksJson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by chen on 2018/3/24.
 */
@Mapper
public interface BooksMapper {
    //查询所有书列表
    List<BooksJson> queryAllBooks();

    //添加书单
    void addBook(AddBookEntity addBookEntity);

    //删除书单
    void deleteBookById(Integer id);

    //更新书单
    void updateBookById(BooksEntity booksEntity);

    //根据id查找书
    BooksJson queryBookById(Integer id);
}
