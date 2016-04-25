package com.mytest.shiro.filters;

import com.mytest.domain.UserLogin;
import com.mytest.service.IUserLoginService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hebo on 2016/4/7.
 */
public class AuthenticationFilter extends FormAuthenticationFilter {

    @Autowired
    private IUserLoginService loginService;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        Subject subject = getSubject(request, response);
        Integer uid = subject.getPrincipal() == null ? null : Integer.parseInt(subject.getPrincipal().toString());
        //如果 isAuthenticated 为 false 证明不是登录过的，同时 isRememberd 为true 证明是没登陆直接通过记住我功能进来的
        if (!subject.isAuthenticated() && subject.isRemembered()) {

            //获取session看看是不是空的
            Session session = subject.getSession(true);

            if (session.getAttribute("uid") == null) {

                // 同步uid到session中
                UserLogin loginInfo = null;
                try {
                    loginInfo = loginService.getUserLoginByUid(uid);
                    if (!loginInfo.getStatus().equals(0)) { // 如果用户被停用，不同步session
                        // 同步uid到session中
                        session.setAttribute("uid", uid);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return uid != null && (subject.isAuthenticated() || subject.isRemembered());
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if(this.isLoginRequest(request, response)) {
            if(this.isLoginSubmission(request, response)) {

                return this.executeLogin(request, response);
            } else {

                return true;
            }
        } else {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            String requestedWith = httpRequest.getHeader("X-Requested-With");
            boolean isAjax = requestedWith != null && "XMLHttpRequest".equals(requestedWith);

            if(isAjax){
                httpResponse.setHeader("sessionstatus","timeout");
            }else{
                this.saveRequest(request);
                String loginUrl = this.getLoginUrl();
                httpResponse.sendRedirect(loginUrl);
            }

            return false;
        }
    }
}
