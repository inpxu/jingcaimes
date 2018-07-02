package com.zhiyun.constant;

/**
 * @Auther: sunyuntao
 * @Date: 2018/06/30 09:36
 * @Description:
 */
public enum  OrderStateEnum {

    AUDITED("AS001","已通过"),AUDITING("AS002","审批中"),UNAUDITED("AS003","已驳回");

    private String label;

    private String id;

    OrderStateEnum(String id , String label){
        this.label = label;
        this.id = id;
    }

    public static String getLabelById(String id){
        for(OrderStateEnum orderStateEnum:OrderStateEnum.values()){
            if(orderStateEnum.id.equals(id)){
                return  orderStateEnum.label;
            }
        }
        return "";
    }

}
