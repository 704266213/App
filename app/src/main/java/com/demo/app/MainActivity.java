package com.demo.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.demo.app.callback.ResponseCallBack;
import com.demo.app.http.OnBuildRequestListener;
import com.demo.app.http.OnRequestListener;
import com.demo.app.http.OnRequestStateListener;
import com.demo.app.http.OnResponseListener;
import com.demo.app.http.OnStartRequest;
import com.demo.app.manager.RetrofitManager;
import com.demo.app.model.BaseModel;
import com.demo.app.model.UserInfoModel;
import com.demo.app.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements OnRequestStateListener,OnBuildRequestListener, OnResponseListener<BaseModel<UserInfoModel>> {


    private TextView loadState;
    private OnRequestListener onRequestListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadState = (TextView) findViewById(R.id.loadState);

        onRequestListener =  new OnStartRequest(this,this,this);
        onRequestListener.onStartRequest();
    }

    public void onRefresh(View v){
        onRequestListener.onStartRequest();
    }


    @Override
    public void onStartRequest() {
        loadState.setText("加载中");
    }

    @Override
    public void onRequestSuccess() {
        loadState.setText("加载成功");
    }

    @Override
    public void onRequestFailure() {
        loadState.setText("加载失败");
    }

    @Override
    public Call onBulidRequest() {
        RetrofitManager retrofitManager = RetrofitManager.getInstance();
        ApiService apiService = retrofitManager.create(ApiService.class);
        return apiService.getUserInfo();
    }


    @Override
    public void onSuccess(BaseModel<UserInfoModel> entity) {
        UserInfoModel userInfoModel = entity.getResult();
        Log.e("XLog", "=======userName===================" + userInfoModel.getUserName());
        Log.e("XLog", "=======headUrl===================" + userInfoModel.getHeadUrl());
        Log.e("XLog", "=======sex===================" + userInfoModel.getSex());
    }

    @Override
    public void onFailure(String msg) {

    }


}
