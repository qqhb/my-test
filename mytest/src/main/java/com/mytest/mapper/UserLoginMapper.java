package com.mytest.mapper;

import com.mytest.domain.UserLogin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hebo on 2016/4/6.
 */
public interface UserLoginMapper {

    UserLogin getUserLoginInfo(@Param("phoneNum") String phoneNum, @Param("passWord") String passWord, @Param("fromCookie") Integer fromCookie) throws Exception;

}
