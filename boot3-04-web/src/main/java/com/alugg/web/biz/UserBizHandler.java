package com.alugg.web.biz;

import com.alugg.web.bean.Person;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class UserBizHandler {
    public ServerResponse getUser(ServerRequest request) throws Exception{
        String id = request.pathVariable("id");
        Person person = new Person();

        return ServerResponse
                .ok()
                .body(person);
    }

    public ServerResponse getUsers(ServerRequest request) throws Exception{
        List<Person> list = Arrays.asList(new Person(),
                new Person());
        return ServerResponse
                .ok()
                .body(list);
    }

    public ServerResponse saveUser(ServerRequest request) throws ServletException, IOException {
        Person body = request.body(Person.class);
        log.info("保存信息");
        return ServerResponse
                .ok()
                .build();
    }

    public ServerResponse updateUser(ServerRequest request) {
        log.info("更新信息");
        return ServerResponse
                .ok()
                .build();
    }

    public ServerResponse deleteUser(ServerRequest request) {
        log.info("删除信息");
        return ServerResponse
                .ok()
                .build();
    }
}
