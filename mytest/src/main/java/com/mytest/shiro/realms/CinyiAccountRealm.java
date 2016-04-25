package com.mytest.shiro.realms;

import com.mytest.domain.UserLogin;
import com.mytest.service.IUserLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fuda on 15/7/7.
 */
public class CinyiAccountRealm extends AuthorizingRealm {

    @Autowired
    private IUserLoginService loginService;
    public final static String REALM_NAME = "MyTestShiroRealm";

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {

        SimpleAuthenticationInfo simpleAuthenticationInfo;

        UsernamePasswordToken token = (UsernamePasswordToken)authToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        String host = token.getHost();

        UserLogin loginInfo = new UserLogin();
        //loginInfo.setLoginIp(host);
        Integer uid;

        try {
            uid = loginService.getUserLoginInfo(username,password,0).getUid();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException();
        }

        simpleAuthenticationInfo = new SimpleAuthenticationInfo(uid,password,REALM_NAME);

        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Integer uid = (Integer)getAvailablePrincipal(principals);
        UserLogin loginInfo = null;
        try {
            loginInfo = loginService.getUserLoginByUid(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(loginInfo != null){
            info.addRole(String.valueOf(loginInfo.getRoleId()));
        }
        return info;
    }
}
