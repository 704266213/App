package com.demo.app.http;


import retrofit2.Call;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 15:36
 * 修改人：admin
 * 修改时间：2017/8/17 15:36
 * 修改备注：
 */

public class OnStartRequest implements OnRequestListener {

    private OnBuildRequestListener onBuildRequestListener;
    private OnResponseListener onResponseListener;
    private OnRequestStateListener onRequestStateListener;

    public OnStartRequest(OnRequestStateListener onRequestStateListener,OnBuildRequestListener onBuildRequestListener, OnResponseListener onResponseListener) {
        this.onRequestStateListener = onRequestStateListener;
        this.onBuildRequestListener = onBuildRequestListener;
        this.onResponseListener = onResponseListener;
    }


    public void onStartRequest() {
        if (onBuildRequestListener != null) {
            Call call = onBuildRequestListener.onBulidRequest();
            if (call != null) {
                if (onRequestStateListener != null){
                    onRequestStateListener.onStartRequest();
                }
                call.enqueue(new ResponseCallBack(onRequestStateListener,onResponseListener));
            }
        }

    }


}
