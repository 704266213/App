package com.demo.app.http;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 15:26
 * 修改人：admin
 * 修改时间：2017/8/17 15:26
 * 修改备注：
 */

public interface OnResponseListener<T> {

    void onSuccess(T entity);

    void onFailure(String msg);

}
