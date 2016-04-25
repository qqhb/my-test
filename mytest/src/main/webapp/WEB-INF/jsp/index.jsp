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
<head>
    <title>Index</title>
</head>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.pagination.js"></script>

<body>
<div>
    欢迎${userLogin.userName}同学,您的访问!
</div>

<label> <a href="javaScript:getMessage();"> 点我看消息 </a> </label> </br>

<label> <a href="javaScript:loginOut();"> 退出系统 </a> </label>


<script type="text/javascript">
    function getMessage(){
        window.location ='${cxt}/message';
    }

    function loginOut(){
        window.location ='${cxt}/login/loginOut';
    }
</script>

</body>
</html>
