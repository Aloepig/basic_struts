<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 25.
  Time: 오전 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>제품정보</h1>
<S:property value="productIdLabel"/> : <S:property value="product.name"/>
<br/>
<S:property value="productNameLabel"/> : <S:property value="product.id"/>
<br/>
<S:property value="product.description"/>
</body>
</html>
