package com.demo.app.model;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 13:50
 * 修改人：admin
 * 修改时间：2017/8/17 13:50
 * 修改备注：
 */

public class BaseModel<T> {

    private int code;
    private String msg;
    private T result;

    public BaseModel() {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
