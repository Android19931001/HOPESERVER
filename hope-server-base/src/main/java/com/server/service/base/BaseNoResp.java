package com.server.service.base;

/**
 * @author wangning
 */
public class BaseNoResp<T> {
    public T data;

    public BaseNoResp(T data) {
        this.data = data;
    }
}
