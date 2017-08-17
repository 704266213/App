package com.demo.app.http;

import com.demo.app.model.BaseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 15:32
 * 修改人：admin
 * 修改时间：2017/8/17 15:32
 * 修改备注：
 */

public class ResponseCallBack<T extends BaseModel>  implements Callback<T> {


    private OnResponseListener onResponseListener;
    private OnRequestStateListener onRequestStateListener;
    public ResponseCallBack(OnRequestStateListener onRequestStateListener, OnResponseListener onResponseListener){
        this.onRequestStateListener = onRequestStateListener;
        this.onResponseListener = onResponseListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T entity = response.body();
        if (entity.getCode() == 200){
            if (onRequestStateListener != null){
                onRequestStateListener.onRequestSuccess();
            }
            if (onResponseListener != null){
                onResponseListener.onSuccess(entity);
            }
        } else {
            if (onRequestStateListener != null){
                onRequestStateListener.onRequestFailure();
            }
            if (onResponseListener != null){
                onResponseListener.onFailure(entity.getMsg());
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (onRequestStateListener != null){
            onRequestStateListener.onRequestFailure();
        }
        if (onResponseListener != null){
            onResponseListener.onFailure("");
        }
    }

}
