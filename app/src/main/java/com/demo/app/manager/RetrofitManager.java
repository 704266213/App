package com.demo.app.manager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 13:38
 * 修改人：admin
 * 修改时间：2017/8/17 13:38
 * 修改备注：
 */

public class RetrofitManager {

    private static RetrofitManager instance;
    public  static final String BASEURL="https://raw.githubusercontent.com/704266213/data/"; //服务器地址
    private Retrofit retrofit;


    private RetrofitManager() {
        //1.创建Retrofit对象
        retrofit = new Retrofit.Builder()
                //设置OKHttpClient,如果不设置会提供一个默认的
//                .client(new OkHttpClient())
                //设置baseUrl
                .baseUrl(BASEURL) //
                //添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create())  //解析方法
                .build();
    }
    /**
     * 单例模式
     *
     * @return
     */
    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class){
                if (instance==null){
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }


    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
