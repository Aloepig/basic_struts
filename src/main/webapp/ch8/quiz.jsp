<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 26.
  Time: 오전 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Quiz Page</title>
</head>
<body>
<s:form>
    <s:textfield label="name" name="name"/>
    <s:textfield label="age" name="age"/>
    <s:textfield label="answer" name="answer"/>
    <s:submit/>
</s:form>
</body>
</html>
