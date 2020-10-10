package com.server.service.utils;

import com.server.service.base.BaseNoResp;
import com.server.service.base.BaseRes;
import com.server.service.base.ErrorResp;
import com.server.service.base.Result;
import com.server.service.contant.Contants;

/**
 * @author wangning
 */
public class Res {

    /**
     * 添加返回体
     *
     * @param code
     * @param message
     * @param object
     * @return
     */
    private static Result instance(int code, String message, Object object) {
        return new BaseRes(code, message).setData(object);
    }

    /**
     * 发生异常时返回的实体
     *
     * @param message
     * @return
     */
    public static Result error(String message) {
        return new Result(Contants.ERROR, message);
    }

    /**
     * 请求成功之后的包装类
     *
     * @param object
     * @return
     */
    public static Result ok(Object object) {
        if (object instanceof String) {
            return new Result(Contants.SUCCESS, object.toString());
        }
        return instance(Contants.SUCCESS, Contants.SUCCESS_MSG, object);
    }


    /**
     * 用来返回一些没有出参体的返回数据用
     *
     * @param object
     * @return
     */
    public static BaseNoResp noBody(Object object) {
        return new BaseNoResp(object);
    }
}
