package com.hope.server.base;

/**
 * 调用接口时发生异常时返回的实体
 *
 * @author wangning
 */
public class ErrorResp {
    public String errMsg;

    public ErrorResp(String errMsg) {
        this.errMsg = errMsg;
    }
}
