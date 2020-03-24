<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<html>
    <head lang="en">
        <#--<meta charset="UTF-8"/>-->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
    </head>
    <body>
    <h3>FreeMarker模板引擎测试</h3>


    <h4>基本取值</h4>
    <ul>
        <li>${user.name!}</li>
        <li>${user.language!}</li>
        <li>${user.success?string('成功','失败')}</li>
        <li>${user.birthday?string('yyyy-MM-dd HH:mm:ss')}</li>
        <li>${user.styleShow!}</li>
        <li>${user.styleShow?html}</li> <#--原样输出-->

        <#--定义变量，支持计算和赋值-->
        <#assign num=10 />
        <li>${num*num}</li>
    </ul>


    <h4>list取值</h4>
    <table border="1" cellspacing="0">
        <tr>
            <th>index</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
        </tr>
        <#list userList as user>
            <tr>
                <td>${user_index+1}</td>   <#--as 后面的那个变量，加上 _index，表示循环下标值，序号从1开始，-->
                <td>${user.name}</td>
                <td>${user.cellphone}</td>
                <td>${user.email}</td>
            </tr>
        </#list>
    </table>
    <br/>


    <h4>if-else</h4>
    <#assign age=100>
    <#if age &gt; 18>
        <span color="red">青年</span>
    <#elseif age == 18>
        <span color="red">成年</span>
    <#else>
        <span color="red">少年</span>
    </#if>


    <h4>switch</h4>
    <#assign day='星期二'>
    <#switch day>
        <#case "星期一">
            油焖大虾
            <#break>
        <#case "星期二">
            炸酱面
            <#break>
        <#default>
            肯德基
    </#switch>
    <br/>


    <#--freemarker语法-->
    <#--https://www.cnblogs.com/JealousGirl/p/6914122.html-->

    <#--日期取值-->
    <#--${(finEndDate?string('yyyy-MM-dd'))!"__________"}-->

    <h4>拼接string数组</h4>
    <#list userList as user>${user.name!"__________"}<#if user_has_next>;</#if></#list>  <#--as后变量拼接 “_has_next”-->


    </body>
</html>