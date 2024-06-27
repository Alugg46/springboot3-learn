package com.alugg.boot.config;

import com.alibaba.druid.FastsqlException;
import com.alugg.boot.bean.Cat;
import com.alugg.boot.bean.Dog;
import com.alugg.boot.bean.Sheep;
import com.alugg.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(Sheep.class)  //通常导入第三方包，第三方包写了@configurationProperties自动赋值
@SpringBootConfiguration
public class AppConfig2 {

    @ConditionalOnClass(name="com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01(){
        return new Cat();
    }

    @ConditionalOnMissingClass(value="com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01(){
        return new Dog();
    }

    @ConditionalOnBean(name= "dog01")
    @Bean
    public User zhangsan(){
        return new User();
    }

    @ConditionalOnMissingBean(name= "dog01")
    @Bean
    public User lisi(){
        return new User();
    }
}
