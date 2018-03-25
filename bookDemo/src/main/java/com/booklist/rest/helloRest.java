package com.booklist.rest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chen on 2018/3/24.
 */
@RestController
public class helloRest {
    @RequestMapping(value="/hello")
    public String getHelloSpring(){
        return "Hello Spring!";
    }
}
