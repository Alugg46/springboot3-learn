package com.alugg.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice //这个类是集中处理所有@Controller发生的错误
public class GobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return "ohoh" + e.getMessage();
    }

}
