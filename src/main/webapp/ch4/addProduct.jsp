<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 25.
  Time: 오전 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<s:form action="addProduct">
    <h1>제품등록</h1>
    <s:textfield label="%{getProductIdLabel()}" name="product.id"/>
    <s:textfield label="%{getText('label.product.name')}" name="product.name"/>
    <s:textfield label="상품설명" name="product.description"/>
    <s:submit value="ADD"/>
</s:form>
</body>
</html>
