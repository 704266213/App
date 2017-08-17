package com.demo.app.model;

/**
 * 项目名称：App
 * 类描述：
 * 创建人：admin
 * 创建时间：2017/8/17 13:52
 * 修改人：admin
 * 修改时间：2017/8/17 13:52
 * 修改备注：
 */

public class UserInfoModel extends BaseModel<UserInfoModel> {

    private String userName;
    private String headUrl;
    private int sex;

    public UserInfoModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
