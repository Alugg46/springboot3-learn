package com.alugg.boot.config;

import com.alibaba.druid.FastsqlException;
import com.alugg.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FastsqlException.class)//导入第三方类，组件名默认是全类名。
@SpringBootConfiguration
//@Configuration //配置类本身也是容器中的组件
public class AppConfig {

    @Bean("userHaha") //替代以前Bean标签， 组件再容器中的名字是方法名，可以直接修改注解的值
    public User user01(){
        User user = new User();
        user.setId(1L);
        user.setName("alugg");
        return user;
    }


}

