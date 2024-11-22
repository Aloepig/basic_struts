<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 22.
  Time: 오전 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Movie Rank</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Stars</th>
    </tr>
    <s:iterator value="movies">
        <tr>
            <td><s:property value="movieId"/></td>
            <td><s:property value="movieName"/></td>
            <td><s:property value="movieStars"/>
                <s:iterator begin="1" end="movieStars">
                    *
                </s:iterator>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
