package com.zhiyun.constant;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/25 11:18
 * @Description:
 */
public enum ProcessStateEnum {

    DISPATCHING("0","代派中"),PROCESSING("1","处理中"),PROCESSED("2","已完成");

    private String id;

    private String name;

    ProcessStateEnum(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
