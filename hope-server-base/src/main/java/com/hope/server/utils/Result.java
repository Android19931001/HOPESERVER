package com.hope.server.utils;

import com.hope.server.base.BaseNoResp;
import com.hope.server.base.BaseRes;
import com.hope.server.base.ErrorResp;
import com.hope.server.contant.Contants;

/**
 * @author wangning
 */
public class Result {

    /**
     * 添加返回体
     *
     * @param code
     * @param message
     * @param object
     * @return
     */
    private static BaseRes instance(int code, String message, Object object) {
        return new BaseRes(code, message).setData(object);
    }

    /**
     * 发生异常时返回的实体
     *
     * @param code
     * @param message
     * @param errorResp
     * @return
     */
    private static BaseRes error(int code, String message, ErrorResp errorResp) {
        return new BaseRes(code, message).setData(errorResp);
    }


    /**
     * 请求成功之后的包装类
     *
     * @param object
     * @return
     */
    public static BaseRes ok(Object object) {
        return instance(Contants.SUCCESS, Contants.SUCCESS_MSG, object);
    }


    /**
     * 请求失败之后的包装类
     * @param errorResp
     * @return
     */
    public static BaseRes error(ErrorResp errorResp) {
        return error(Contants.ERROR, Contants.ERROR_MSG, errorResp);
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
