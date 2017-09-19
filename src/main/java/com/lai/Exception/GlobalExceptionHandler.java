package com.lai.Exception;

import com.lai.ExceptionInfo.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lailai on 2017/9/19.
 * 全局的异常处理
 */
@ControllerAdvice    //定义统一的异常处理类
public class GlobalExceptionHandler {

    private static final String default_error_view="error";

    /**
     * 返回html页面
     * 通过@ExceptionHandler配置异常类型，不同的Exception映射到不同的异常处理页面
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)   //定义函数针对的异常类型
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        ModelAndView model=new ModelAndView();
        model.addObject("exception",e);
        model.addObject("url",request.getServletPath()+":"+request.getServerPort());
        model.addObject("method",request.getMethod());
        model.setViewName(default_error_view);
        return model;
    }

    /**
     * 返回Json格式信息
     * 不同的异常类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonExceptionHandler(HttpServletRequest request,MyException e) throws Exception{
        ErrorInfo<String> data=new ErrorInfo<>();
        data.setMessage(e.getMessage());
        data.setCode(ErrorInfo.ERROR);
        data.setData("some data");
        data.setUrl(request.getRequestURI().toString());
        return data;
    }
}
