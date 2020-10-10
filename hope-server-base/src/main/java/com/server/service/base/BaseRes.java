package com.server.service.base;

/**
 * @author wangning
 */
public class BaseRes<T> extends Result{

    private T data;

    public BaseRes() {

    }

    public BaseRes(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public BaseRes setData(T data) {
        this.data = data;
        return this;
    }
}
