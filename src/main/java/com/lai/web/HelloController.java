package com.lai.web;

import com.lai.Exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lailai on 2017/9/19.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String Hello() throws Exception{
        throw new Exception("发生错误");
    }

    @GetMapping(value = "/json")
    public String json() throws MyException{
        throw  new MyException("发送错误了");
    }
}
