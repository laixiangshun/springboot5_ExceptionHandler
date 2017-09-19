package com.lai.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/9/19.
 * 通过注解来加载对应的配置属性
 */
@Component
public class BlogProperties {

    @Value("${com.lai.blog.name}") //加载配置文件中com.lai.blog.name属性
    private String name;

    @Value("${com.lai.blog.title}")
    private String title;

    //静态属性
    private static String content;

    @Value("${com.lai.blog.des}")
    private String des;

    public static String getContent() {
        return content;
    }
    @Value("${com.lai.blog.content}")  //给静态属性赋值配置的属性值，@Value对正常的方法可以生效
    public void setContent(String content) {
        BlogProperties.content = content;
    }

    public BlogProperties() {
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
