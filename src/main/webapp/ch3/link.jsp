<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 21.
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>Link Test</title>
  </head>
  <body>
  <s:url var="gotoLinkAction" action="gotoLink">
    <s:param name="message">전송할 메세지</s:param>
  </s:url>
  <s:a href="%{gotoLinkAction}">gotoLinkAction</s:a>
  </body>
</html>
