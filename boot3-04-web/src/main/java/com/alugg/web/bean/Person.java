package com.alugg.web.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data //自动生成getter/setter
@JacksonXmlRootElement //可以写出xml文档
public class Person {
    private String name;
    private Integer age;
    private Date birthDay;
    private Boolean like;

}
