package com.mytest.mapper;



import com.mytest.common.page.Page;
import com.mytest.domain.UserMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hebo on 2016/4/7.
 */
public interface UserMessageMapper {

    public List<UserMessage> getUserMessagesPageList(@Param("uid") Integer uid, @Param("page") Page page) throws Exception;
}
