package com.alugg.web.controller;

import com.alugg.web.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class HelloController {
    @GetMapping("/a*/b?/{p1:[a-f]+}")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path){
        log.info("路径变量p1:{}", path);
        String uri = request.getRequestURI();
        return uri;
    }

    @GetMapping("/person")
    public Person person(){
        Person person = new Person();
        person.setLike(true);
        person.setAge(15);
        person.setName("alugg");
        return person;
    }

//    /**
//     * 1.@ExceptionHandler 标识一个方法处理错误，默认只能处理这个类发送的指定错误
//     * 2.@ControllerAdvice 统一处理所有错误
//     * @param e
//     * @return
//     */
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception e){
//        return "ohoh" + e.getMessage();
//    }
}
