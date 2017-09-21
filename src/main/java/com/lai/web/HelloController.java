package com.lai.web;

import com.lai.Exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lailai on 2017/9/19.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String Hello() throws Exception{
        //throw new Exception("发生错误");
        return "hello";
    }

    @GetMapping(value = "/json")
    @ResponseBody
    public String json() throws MyException{
        //throw  new MyException("发送错误了");
        return "json";
    }

    @RequestMapping(value = "/aspect",method = RequestMethod.GET)
    @ResponseBody
    public String aspect(@RequestParam("name") String name){
        return "this is aspect "+name;
    }
}
