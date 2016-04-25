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
  <title>Message Info</title>
</head>
<body>

<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.pagination.js"></script>

<div class="newsCenterBox">

</div>

<!-- 分页 -->
<div style="display: none" id="Pagination" class="paging"></div>

<script type="text/javascript">
  //当前页
  var pageIndex = 0;
  // 每页条数
  var pageSize = 2;
  $(function(){
    //消息
    getMasterListJson(0);
  });

  //获取分页数据组件
  function getMasterListJson(pageIndex){

    var param = {
      start: pageIndex + 1,
      rows: pageSize

    };
    $.getJSON('${ctx}/message/getMessageInfoByUid?r='+Math.random(),param,function(data){

      if(data.result){
        // 注册分页控件
        $("#Pagination").pagination(data.content.total,{
          callback: pageCallback,
          prev_text: '上一页',
          next_text: '下一页',
          items_per_page: pageSize,
          num_display_entries: 8,// 连续分页主体部分分页条目数
          current_page: pageIndex,// 当前页索引
          num_edge_entries: 1 // 两侧首尾分页条目数
        });
        var masterList = '', masterLength = data.content.list.length;

        for(var i = 0; i < masterLength; i++){
          //默认已读
          var readFlag = data.content.list[i].readFlag;
          var readFlagStr = "newsCenterInfo";
          if(readFlag == 1){//已读
            readFlagStr = "newsCenterInfo";
          }else{//未读
            readFlagStr = "newsCenterInfo bgColor";
          }

          //判断是什么类型的消息,第一版只有系统消息
          var type = data.content.list[i].type;
          var typeStr = "未知来源";
          if(type == 1){
            typeStr = "系统消息";
          }

          //判断超链没有连接就不显示
          var linkUrl = data.content.list[i].linkUrl;
          var styleStr = "display:''";
          if(linkUrl.length < 1){
            styleStr = "display:none";
          }

          masterList += '<div class="'+readFlagStr+'">'
          +'<img src="/images/news_img.png" alt="">'
          +'<div class="Info">'
          +'<h5>'+typeStr+'</h5>'
          +'</div>'
          +'</div>'
        }

        $('.newsCenterBox').html(masterList);
        if(data.content.total > pageSize){
          $('#Pagination').show();
        }else{
          $('#Pagination').hide();
        }
      }else{
        $('#Pagination').hide();
      }
    });
  }


  function pageCallback(pageIndex){
    getMasterListJson(pageIndex);
  }

</script>
</body>
</html>
