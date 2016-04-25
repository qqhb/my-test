package com.mytest.service.service.impl;

import com.mytest.common.page.Page;
import com.mytest.common.page.PageResult;
import com.mytest.domain.UserMessage;
import com.mytest.mapper.UserMessageMapper;
import com.mytest.service.IUserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hebo on 2016/4/7.
 */
@Service
public class UserMessageService implements IUserMessageService {

    @Autowired
    private UserMessageMapper userMessageMapper;

    @Override
    public PageResult<UserMessage> getUserMessagesPageList(Integer uid, Integer curryPage, Integer rows) throws Exception {
        Page page = getPage(curryPage,rows);
        List<UserMessage> userMessageList = userMessageMapper.getUserMessagesPageList(uid, page);

        PageResult<UserMessage> messagePageResult = new PageResult<UserMessage>();
        messagePageResult.setList(userMessageList);
        messagePageResult.setTotalCount(page.getTotalCount());
        return messagePageResult;
    }

    /**
     * 获取page基本信息
     * @param currentPage
     * @param rows
     * @return
     */
    private Page getPage(Integer currentPage, Integer rows){
        Page page;
        if (currentPage == null) {
            page = new Page(1, Integer.MAX_VALUE);
        } else {
            if (rows == null) {
                page = new Page(currentPage, 20);
            } else {
                page = new Page(currentPage, rows);
            }
        }
        return page;
    }
}
