package com.mytest.utils;

/**
 * Created by hebo on 2016/2/4.
 */
public class JsonResponse {

    /**
     * 请求结果
     */
    private boolean result;

    /**
     * 消息描述
     */
    private String message;

    /**
     * 请求的数据内容
     */
    private Object content;

    private JsonResponse(Builder b) {
        this.result = b.result;
        this.message = b.message;
        this.content = b.content;
    }

    public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder{

        private boolean result;

        private String message="";

        private Object content="";

        public Builder(boolean result){
            this.result = result;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Builder content(Object content){
            this.content = content;
            return this;
        }

        public JsonResponse build(){
            return new JsonResponse(this);
        }
    }

}
