package com.james.model;

import java.io.Serializable;

/**
 * Created by gaoji on 2016/11/05.
 */
public class UserBean implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6265618982116673405L;

    /**
     * 用户名
     */
    public String userName;

    /**
     * 密码
     */
    public String password;

    /**
     * 邮箱
     */
    public String email;

    /**
     * 电话
     */
    public String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
