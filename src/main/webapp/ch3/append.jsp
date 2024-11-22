<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 22.
  Time: 오후 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Append Test</title>
</head>
<body>
<s:append var="appendVar">
    <s:param value="list1"/>
    <s:param value="list2"/>
</s:append>
<s:iterator value="appendVar">
    <s:property />
</s:iterator>
</body>
</html>
