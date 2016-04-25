package com.mytest.service;

import com.mytest.domain.UserLogin;

/**
 * Created by hebo on 2016/4/1.
 */
public interface IUserLoginService {
    /**
     * 根据uid获取用户信息
     * @param uid
     * @return
     * @throws Exception
     */
    public UserLogin getUserLoginByUid(Integer uid) throws  Exception;

    public UserLogin getUserLoginInfo(String loginName, String passWord,Integer fromCookie) throws Exception;
}
