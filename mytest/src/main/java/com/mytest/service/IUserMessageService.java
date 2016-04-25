package com.mytest.service;

import com.mytest.common.page.PageResult;
import com.mytest.domain.UserMessage;

/**
 * Created by hebo on 2016/4/7.
 */
public interface IUserMessageService {

    /**
     *
     * @param uid 用户ID
     * @param curryPage 当前页
     * @param rows 一页显示多少行
     * @return
     * @throws Exception
     */
    public PageResult<UserMessage> getUserMessagesPageList(Integer uid, Integer curryPage, Integer rows) throws Exception;
}
