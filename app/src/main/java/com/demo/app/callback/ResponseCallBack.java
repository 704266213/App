package com.demo.app.callback;


import com.demo.app.model.BaseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 14:21
 * 修改人：admin
 * 修改时间：2017/8/17 14:21
 * 修改备注：
 */

public class ResponseCallBack<T extends BaseModel> implements Callback<T> {

    private CallBack callBack;
    public ResponseCallBack(CallBack callBack){
        this.callBack = callBack;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T entity = response.body();
        if (entity.getCode() == 200){
            if (callBack != null){
                callBack.onSuccess(entity);
            }
        } else {
            if (callBack != null){
                callBack.onFailure(entity.getMsg());
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (callBack != null){
            callBack.onFailure("");
        }
    }

    public interface CallBack<T extends BaseModel>{

        void onSuccess(T entity);

        void onFailure(String msg);

    }
}
