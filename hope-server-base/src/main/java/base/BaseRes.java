package base;

/**
 * @author wangning
 */
public class BaseRes<T> {

    private int code;

    private String message;

    private T data;

    public BaseRes() {

    }

    public BaseRes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public BaseRes setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseRes setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseRes setData(T data) {
        this.data = data;
        return this;
    }
}
