<%--
  Created by IntelliJ IDEA.
  User: xingding
  Date: 18/4/19
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    上下文
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title>上传示例</title>
</head>
<body>
    <h1>上传成功</h1>
    <%--<img src="${basePath}${imgpath}"/>--%>
    <img src="/showPic.do?filePath=${imgpath}"/>
</body>
</html>
