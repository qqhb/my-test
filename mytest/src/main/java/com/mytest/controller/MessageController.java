package com.mytest.controller;

import com.mytest.common.page.PageResult;
import com.mytest.domain.UserMessage;
import com.mytest.service.IUserMessageService;
import com.mytest.utils.JsonResponse;
import com.mytest.vo.UserMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hebo on 2016/4/7.
 */

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IUserMessageService userMessageService;

    @RequestMapping("/getMessageInfoByUid")
    @ResponseBody
    public JsonResponse getMessageInfoByUid(HttpServletRequest request,HttpServletResponse response,
                                            Integer start, Integer rows){
        String uidStr = request.getSession().getAttribute("uid")+"";
        Integer uid = 0;
        if("".equals(uidStr) || "null".equals(uidStr) || null == uidStr){
            uid = 1001;
        }else {
            uid = Integer.valueOf(uidStr);
        }

        PageResult<UserMessage> result = null;
        Map<String,Object> resMap = null;
        List<UserMessageVo> messageVos = new ArrayList<UserMessageVo>();
        HttpSession httpSession = request.getSession();
        try {
            result = userMessageService.getUserMessagesPageList(uid,start,rows);
            List<UserMessage> list = result.getList();
            for (int i = 0; i < result.getList().size(); i++){
                UserMessageVo messageVo = new UserMessageVo();
                UserMessage userMessage = result.getList().get(i);
                messageVo.setId(userMessage.getId());
                messageVo.setType(userMessage.getType());
                messageVo.setTitle(userMessage.getTitle());
                messageVo.setContent(userMessage.getContent());
                messageVo.setTarget(userMessage.getTarget());
                messageVo.setStatus(userMessage.getStatus());
                messageVo.setLinkUrl(userMessage.getLinkUrl());
                messageVo.setReadFlag(userMessage.getReadFlag());
                messageVos.add(messageVo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resMap = new HashMap<String,Object>();
        resMap.put("list",messageVos);
        resMap.put("total",result.getTotalCount());

        JsonResponse jsonResponse = new JsonResponse.Builder(true).content(resMap).build();
        return jsonResponse;


    }
}
