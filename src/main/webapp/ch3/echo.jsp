<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 21.
  Time: 오후 2:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Form Test</title>
</head>
<body>
    <s:form action="echo" theme="simple">
        <s:textfield name="echoMessage" />
        <s:property value="%{'re:' + getEchoMessage()}" />
        <s:property value="echoMessage" />
        <s:textarea name="articleSimple" theme="simple" />
        <s:submit/>
    </s:form>
</body>
</html>
