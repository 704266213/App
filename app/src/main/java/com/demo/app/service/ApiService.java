package com.demo.app.service;

import com.demo.app.model.BaseModel;
import com.demo.app.model.UserInfoModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 13:49
 * 修改人：admin
 * 修改时间：2017/8/17 13:49
 * 修改备注：
 */

public interface ApiService {

    @GET("master/WebContent/data/userinfo.json")
    Call<BaseModel<UserInfoModel>> getUserInfo();
}
