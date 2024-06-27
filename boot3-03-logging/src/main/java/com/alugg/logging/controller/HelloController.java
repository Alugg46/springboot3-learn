package com.alugg.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/h")
    public String hello(String a, String b){
        log.trace("traceooo");
        log.debug("debug ooo");
        log.info("hhaha,methode 参数a:{} 参数b:{}",a,b);
        log.warn("warn oooo");
        log.error("error");

        return "hello";
    }
}
