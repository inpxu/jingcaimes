#晶彩工艺任务管理系统

----------
- swagger的使用

1. 在controller上使用注解 

        @Api(tags = "工艺评审", description = "工艺评审增删改查")
        
        tags 修改为controller模块对应的释义，description为描述信息
        
 2. 在各方法上使用注解
 
       方法描述：
       
        @ApiOperation(value = "通过http的形式发送消息", httpMethod = "POST", response = String.class, notes = "消息发送")
       
       参数：
       
        @ApiImplicitParams({@ApiImplicitParam(name = "queueName", value = "队列名", required = true, paramType = "string"),
                                      @ApiImplicitParam(name = "appSrc", value = "消息来源", required = true, paramType = "string"),
                                      @ApiImplicitParam(name = "messageType", value = "消息类型", required = true, paramType = "string"),
                                      @ApiImplicitParam(name = "message", value = "消息内容", required = true, paramType = "string")})
                                      
                                      
                                      
         当参数为实体类接收时。         
                                      
                                      
                                      
        
 3. 访问地址
 
        swagger的访问地址为 http://localhost:8080/swagger-ui.html