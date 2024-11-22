<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 22.
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Method Prefix</title>
</head>
<body>
<s:form action="methodTest" theme="simple">
    <s:textfield name="name"/>
    <s:submit value="승인"/>
    <s:submit value="취소" name="submitType"/>
    <h1>결과</h1>
    <s:property value="message"/>
</s:form>
</body>
</html>
