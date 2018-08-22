<!DOCTYPE html>
<html lang=en>
<head>
    <meta charset=utf-8>
    <title>MES管理系统</title>
    <link href=/mes/static/css/app.639774fc0effddea93af5dd599022ac6.css rel=stylesheet>
</head>
<link rel=stylesheet href=/mes/static/webuploader.css>
<script src=/mes/static/jquery-3.2.1.min.js></script>
<script src=/mes/static/webuploader.js></script>
<body>
<div id=app>
    <app ports=http://192.168.0.57:8888/mes user-name="${userName}"
    <#--<app ports=http://192.168.0.188:8884/mes user-name="${userName}"-->
         user-img=http://61.153.187.242:8049/appSign/user.png
         company-name=MES管理系统 company-english=${companyName}
                 menu-list='[{"appId":"160","code":"wk","alias":"物控中心","descs":"物控中心","parentId":"0","path":"1813","id":"1813"},{"appId":"160","code":"technology","alias":"工艺设置","descs":"工艺设置","parentId":"1813","path":"1813,1814","id":"1814"}
         ,{
    "appId":"160","code":"product","alias":"产品库","descs":"产品库","parentId":"1813","path":"1813,1815","id":"1815"}
    ,{"appId":"160","code":"semi-manufactures","alias":"半成品库","descs":"半成品库","parentId":"1813","path":"1813,1816","id":"1816"}
    ,{"appId":"160","code":"productProcess","alias":"产品工艺","descs":"产品工艺","parentId":"1813","path":"1813,1817","id":"1817"}
    ,{"appId":"160","code":"pc","alias":"排程管理","descs":"排程管理","parentId":"0","path":"1818","id":"1818"}
    ,{"appId":"160","code":"internalOrder","alias":"内部订单","descs":"内部订单","parentId":"1818","path":"1818,1819","id":"1819"}
    ,{"appId":"160","code":"approve","alias":"内部订单审批","descs":"内部订单审批","parentId":"1818","path":"1818,1820","id":"1820"}
    ,{"appId":"160","code":"tasking","alias":"工艺任务分配","descs":"工艺任务分配","parentId":"1818","path":"1818,1821","id":"1821"}
    ,{"appId":"160","code":"receive","alias":"工艺任务领取","descs":"工艺任务领取","parentId":"1818","path":"1818,1822","id":"1822"}
    ,{"appId":"160","code":"taskingRecord","alias":"任务分配记录","descs":"任务分配记录","parentId":"1818","path":"1818,1823","id":"1823"}
    ,{"appId":"160","code":"rwjg","alias":"任务交工","descs":"任务交工","parentId":"0","path":"1824","id":"1824"}
    ,{"appId":"160","code":"jobAssignment","alias":"交工","descs":"交工","parentId":"1824","path":"1824,1825","id":"1825"}
    ,{"appId":"160","code":"jobAssignmentHistory","alias":"任务交工记录","descs":"任务交工记录","parentId":"1824","path":"1824,1826","id":"1826"}
    ,{"appId":"160","code":"electronicHairMap","alias":"电子发图","descs":"电子发图","parentId":"0","path":"1827","id":"1827"}
    ,{"appId":"160","code":"customerManagement","alias":"客户管理","descs":"客户管理","parentId":"0","path":"1828","id":"1828"}
    ,{"appId":"160","code":"customerReview","alias":"客户评审","descs":"客户评审","parentId":"1828","path":"1828,1830","id":"1830"}
    ,{"appId":"160","code":"customerProcessReview","alias":"客户工艺评审","descs":"客户工艺评审","parentId":"1828","path":"1828,1831","id":"1831"}
    ,{"appId":"160","code":"customerUploadData","alias":"客户上传资料","descs":"客户上传资料","parentId":"1828","path":"1828,1832","id":"1832"}
    ,{"appId":"160","code":"seeUpload","alias":"查看上传资料","descs":"查看上传资料","parentId":"1828","path":"1828,1829","id":"1829"}]'
    company-logo=http://61.153.187.80:9000/group1/M00/00/3C/wKgBDFt7cqSAQI1UAAALDWGm2uo464.png></app>
</div>
<script type=text/javascript src=/mes/static/js/manifest.2ae2e69a05c33dfc65f8.js></script>
<script type=text/javascript src=/mes/static/js/vendor.ee555654c7d79fb82264.js></script>
<script type=text/javascript src=/mes/static/js/app.4e2b1dab63e73d6b0705.js></script>
</body>
</html>