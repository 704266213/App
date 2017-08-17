package com.demo.app.http;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 15:54
 * 修改人：admin
 * 修改时间：2017/8/17 15:54
 * 修改备注：
 */

public interface OnRequestStateListener {

    void onStartRequest();

    void onRequestSuccess();

    void onRequestFailure();
}
