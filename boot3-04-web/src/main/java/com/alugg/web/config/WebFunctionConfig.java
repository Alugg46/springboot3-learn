package com.alugg.web.config;

import com.alugg.web.bean.Person;
import com.alugg.web.biz.UserBizHandler;
import org.apache.coyote.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.*;

import javax.print.attribute.standard.Media;

@Configuration
public class WebFunctionConfig {
    /**
     * 函数式Web：
     * 1. 给容器放一个Bean，类型是RouterFunction<ServerResponse>
     * 2.每个业务准备一个自己的handler
     *
     *  核心四大对象
     *  1.RouterFunction:定义路由信息。 发什么请求，谁来处理
     *  2.RequestPredicate: 请求方式
     *  3.ServerRequest：请求
     *  4.ServerResponse:响应
     */
    @Bean
    public RouterFunction<ServerResponse> userRoute(UserBizHandler userBizHandler) {
        return RouterFunctions.route() //开始定义路由信息
                .GET("/user/{id}", RequestPredicates.accept(MediaType.ALL), userBizHandler::getUser)
                .GET("/users", userBizHandler::getUsers)
                .POST("/user", RequestPredicates.accept(MediaType.APPLICATION_JSON), userBizHandler::saveUser)
                .PUT("/user/{id}", RequestPredicates.accept(MediaType.APPLICATION_JSON), userBizHandler::updateUser)
                .DELETE("/user/{id}", userBizHandler::deleteUser)
                .build();}

}
