package com.mytest.service.service.impl;

import com.mytest.domain.UserLogin;
import com.mytest.mapper.UserLoginMapper;
import com.mytest.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hebo on 2016/4/1.
 */
@Service
public class UserLoginService implements IUserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;
    @Override
    public UserLogin getUserLoginByUid(Integer uid) throws Exception {
        UserLogin userLogin = new UserLogin();
        userLogin.setUid(1001);
        String loginName = "18811111111";
        String passWord = "12345678";
        Integer fromCookie = 0;

        userLogin = userLoginMapper.getUserLoginInfo(loginName,passWord,fromCookie);

        return userLogin;
    }

    @Override
    public UserLogin getUserLoginInfo(String loginName, String passWord, Integer fromCookie) throws Exception {
        UserLogin userLogin = userLoginMapper.getUserLoginInfo(loginName,passWord,fromCookie);
        return userLogin;
    }
}
