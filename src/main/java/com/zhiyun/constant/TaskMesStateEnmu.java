package com.zhiyun.constant;

public enum  TaskMesStateEnmu {

    DISPATCHING("0","待派工"),PROCESSING("1","处理中"),DONE("2","已完成");

    private String id;

    private String name;

    TaskMesStateEnmu(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
