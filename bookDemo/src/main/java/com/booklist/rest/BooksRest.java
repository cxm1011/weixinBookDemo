package com.booklist.rest;

import com.booklist.model.BooksEntity.AddBookEntity;
import com.booklist.model.BooksEntity.BooksEntity;
import com.booklist.model.BooksJson.BooksJson;
import com.booklist.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chen on 2018/3/24.
 */
@RestController
public class BooksRest {
    @Autowired
    private BooksService booksService;

    @GetMapping(value = "/queryBooks")
    public Map<String,Object> queryBooks(){
        Map<String,Object> modelMap = new HashMap<>();
        List<BooksJson> booksList = booksService.queryAllBooks();
        modelMap.put("booksList",booksList);
        return modelMap;
    }

    @GetMapping(value = "/queryBookById")
    public Map<String,Object> queryBookById(@RequestParam(value="id") Integer id){
        Map<String,Object> modelMap = new HashMap<>();
        BooksJson book = booksService.queryBookById(id);
        modelMap.put("book",book);
        return modelMap;
    }

    @PostMapping(value = "/saveBook")
    public Map<String,Object> saveBook(@RequestBody AddBookEntity addBookEntity){
        Map<String,Object> modelMap = new HashMap<>();
        Boolean saveRes = booksService.addBook(addBookEntity);
        modelMap.put("success",saveRes);
        return modelMap;
    }

    @GetMapping(value = "/deleteBookById")
    public Map<String,Object> deleteBookById(@RequestParam(value="id") Integer id){
        Map<String,Object> modelMap = new HashMap<>();
        Boolean deleteRes = booksService.deleteBookById(id);
        modelMap.put("deleteRes",deleteRes);
        return modelMap;
    }

    @PostMapping(value = "/updateBookById")
    public Map<String,Object> updateBookById(@RequestBody BooksEntity booksEntity){
        Map<String,Object> modelMap = new HashMap<>();
        Boolean updateRes = booksService.updateBookById(booksEntity);
        modelMap.put("success",updateRes);
        return modelMap;
    }
}
