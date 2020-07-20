package com.five.monkey.provider.error;

/**
 *
 *
 * @author jim
 * @date 2020/7/3 18:23
 */
public class BaseResult {

    //返回代码
    private Integer  code;

    //返回消息
    private String message;

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
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
}
