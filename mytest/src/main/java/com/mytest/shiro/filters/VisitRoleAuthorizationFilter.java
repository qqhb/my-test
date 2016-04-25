package com.mytest.shiro.filters;

import com.mytest.domain.UserLogin;
import com.mytest.service.IUserLoginService;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hebo on 2016/4/7.
 */
public class VisitRoleAuthorizationFilter extends AuthorizationFilter {

    @Autowired
    private IUserLoginService loginService;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {

        String[] requireRoles = (String[])o;
        Subject subject = getSubject(servletRequest,servletResponse);
        Integer uid = (Integer)subject.getPrincipal();
        UserLogin loginInfo = loginService.getUserLoginByUid(uid);
        String userRole = String.valueOf(loginInfo.getRoleId());

        boolean isAccessAllowed = false;
        for(String item : requireRoles){
            if (userRole.equals(item)) {
                isAccessAllowed =  true;
                break;
            }
        }

        return isAccessAllowed;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestedWith = httpRequest.getHeader("X-Requested-With");
        boolean isAjax = requestedWith != null && "XMLHttpRequest".equals(requestedWith);

        if(isAjax){
            httpResponse.setHeader("sessionstatus","timeout");
        }else{
            String unauthorizedUrl = this.getUnauthorizedUrl();
            if(StringUtils.hasText(unauthorizedUrl)) {
                WebUtils.issueRedirect(request, response, unauthorizedUrl);
            } else {
                WebUtils.toHttp(response).sendError(401);
            }
        }

        return false;
    }
}
