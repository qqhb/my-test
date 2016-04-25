package com.mytest.controller;

import com.mytest.domain.UserLogin;
import com.mytest.form.LoginForm;
import com.mytest.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by hebo on 2016/4/1.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserLoginService userLoginService;

    @RequestMapping("/getUserLogin")
    public ModelAndView getUserLogin(){
        ModelAndView view = new ModelAndView();
        try {
            UserLogin   userLogin = userLoginService.getUserLoginByUid(1001);
            view.addObject("userLogin",userLogin);
            view.setViewName("index");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        try {
            UserLogin   userLogin = userLoginService.getUserLoginByUid(1001);
            view.addObject("userLogin",userLogin);
            view.setViewName("index");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    /**
     *
     * @param form
     * @param request
     * @return -1:验证通过; 1:用户名不能为空; 2:密码不能为空; 3:用户不存在; 4:密码错误
     */
    @RequestMapping("/checkLogin")
    @ResponseBody
    public Integer checkLogin(LoginForm form, HttpServletRequest request){
        Integer num = -1;
        String loginName = form.getLoginName();
        String passWord = form.getPassWord();
        if("".equals(loginName) || null == loginName){
            return 1;
        }

        if("".equals(passWord) || null == passWord){
            return 2;
        }
        UserLogin userLogin = null;
        try {
            userLogin = userLoginService.getUserLoginInfo(loginName,"",2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(userLogin == null){
            return 3;
        }

        UserLogin userLogin2 = null;
        try {
            userLogin2 = userLoginService.getUserLoginInfo(loginName, passWord, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(userLogin2 == null){
            return 4;
        }

        return num;
    }


    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,LoginForm form){
        String phoneNum = "";
        String passWord = "";
        HttpSession httpSession = request.getSession();
        if(form != null){
            phoneNum = form.getLoginName();
            passWord = form.getPassWord();
        }
        ModelAndView view = new ModelAndView();
        UserLogin userLogin = null;
        try {
            userLogin = userLoginService.getUserLoginInfo(phoneNum,passWord,0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        httpSession.setAttribute("uid",userLogin == null ? "":userLogin.getUid());
        httpSession.setAttribute("userName",userLogin == null ? "":userLogin.getUserName());
        view.addObject("userLogin",userLogin);
        view.setViewName("index");

        return view;
    }


    @RequestMapping("/loginOut")
    public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response,LoginForm form){
        ModelAndView view = new ModelAndView();
        HttpSession httpSession = request.getSession();
        String uid = httpSession.getAttribute("uid")+"";
        httpSession.removeAttribute(uid);
        httpSession.setMaxInactiveInterval(0);
        view.setViewName("login");
        return view;
    }


}
