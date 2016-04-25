package com.mytest.domain;

/**
 * Created by hebo on 2016/4/7.
 */
public class UserMessage {
    /**
     * 消息ID
     */
    private Integer id;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 消息头
     */
    private String title;

    /**
     * 消息体
     */
    private String content;

    /**
     * 目标
     */
    private Short target;

    /**
     * 消息状态
     */
    private Integer status;

    /**
     * 跳转链接
     */
    private String linkUrl;

    /**
     * 读取标志
     */
    private short readFlag;

    /**
     * 消息关联ID
     */
    private Integer messageRefId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getTarget() {
        return target;
    }

    public void setTarget(Short target) {
        this.target = target;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public short getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(short readFlag) {
        this.readFlag = readFlag;
    }

    public Integer getMessageRefId() {
        return messageRefId;
    }

    public void setMessageRefId(Integer messageRefId) {
        this.messageRefId = messageRefId;
    }
}
