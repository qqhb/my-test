package com.mytest.domain;

import java.util.Date;

/**
 * Created by hebo on 2016/4/1.
 */
public class UserLogin {
    /** 主键Id.*/
    private Integer uid;

    /** 手机号.*/
    private String phoneNum;

    /** 密码（加密）.*/
    private String password;

    /** 用户名.*/
    private String userName;

    /** 0、普通用户  1、下端医院.*/
    private Integer roleId;

    /** 用户状态：0、停用；1、正常.*/
    private Integer status;

    /** 最后登录时间.*/
    private Date lastLoginTime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
