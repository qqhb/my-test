<%--
  Created by IntelliJ IDEA.
  User: cinyi
  Date: 2016/4/6
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/common/commonTag.jsp" %>
<html>
<style>
  body {TEXT-ALIGN: center;}
  #center {
    MARGIN-RIGHT: auto;
    MARGIN-LEFT: auto;
  }
</style>
<head>
  <title>Login</title>
</head>
<body>
<div id = "center">
  <form id="loginForm" name="loginForm" method="post" action="${ctx}/login/login">
    <label>账号:</label><label><input type="text" id="loginName" name="loginName"/></label>
    </br>
    <label>口令:</label><label><input type="password" id="passWord" name="passWord"/></label>
    </br>
    <label style="margin-left: 164px"><input type="button" onclick="login();" value="确定"/> </label>
  </form>
</div>
</body>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.pagination.js"></script>
<script type="text/javascript">
  function login(){
    var loginName = $("#loginName").val();
    var passWord = $("#passWord").val();

    if(loginName == undefined || '' == loginName){
      alert("请输入账号");
      return false;
    }

    if(passWord == undefined || '' == passWord){
      alert("请输入口令");
      return false;
    }

    //校验用户口令是否正确
    var flag = false;
    $.ajax({
      url:'${cxt}/login/checkLogin',
      type:'POST',
      async: false,
      data:{
        "loginName":loginName,
        "passWord":passWord
      },
      dataType: 'json',
      success: function(data){
        if (data == 1) {
          alert('用户名不存在');
          return flag;
        } else if (data == 2) {
          alert('密码错误');
          return flag;
        } else{
          flag = true;
          return flag;
        }
      }
    });


    if(flag){
      //提交登录
      $("#loginForm").submit();
    }

  }
</script>
</html>
