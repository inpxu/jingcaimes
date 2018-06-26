package com.zhiyun.constant;

/**
 * @Auther: sunyuntao
 * @Date: 2018/6/22 20:05
 * @Description:
 */
public enum OrderSourceEnum {

    SALES_ORDER(1,"销售订单"),FORECASTING_SALES(2,"销售预测"),WAREHOUSE_REQUIREMENTS(3,"库存要求");

    private String label;

    private Integer id;

    OrderSourceEnum(Integer id , String label){
        this.label = label;
        this.id = id;
    }

    public String getLabelById(Integer id){
        for(OrderSourceEnum orderSourceEnum:OrderSourceEnum.values()){
            if(orderSourceEnum.id.equals(id)){
                return  orderSourceEnum.label;
            }
        }
        return "";
    }


}
