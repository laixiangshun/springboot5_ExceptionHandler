package com.lai.ExceptionInfo;

/**
 * Created by lailai on 2017/9/19.
 * 定义统一的json格式异常的返回对象
 */
public class ErrorInfo<T> {
    public static final Integer OK=0;
    public static final Integer ERROR=100;

    private Integer code; //信息类型
    private String message; //信息内容
    private  String url;  //请求url
    private T data; //请求返回内容

    public ErrorInfo() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
