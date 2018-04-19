<%--
  Created by IntelliJ IDEA.
  User: xingding
  Date: 18/4/19
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传示例</title>
</head>
<body>
<form name="Form2" action="/springUpload.do" method="post"  enctype="multipart/form-data">
    <h1>使用spring mvc提供的类的方法上传文件</h1>
    <input type="file" name="file">
    <input type="submit" value="upload"/>
</form>
</body>
</html>
