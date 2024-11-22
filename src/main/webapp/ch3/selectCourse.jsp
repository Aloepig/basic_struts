<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 22.
  Time: 오전 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Select Course</title>
</head>
<body>
<s:form action="selectCourse" method="post" theme="simple">
    <h2>List</h2>
    <s:select name="listCheck" list="listCourse" multiple="true"/>
    <s:iterator value="listCheck">
        <s:property/>
    </s:iterator>

    <h2>Map</h2>
    <s:select name="courseName" list="mapCourse"/>
    <s:property value="courseName"/>

    <h2>Class</h2>
    <s:select name="courseId" list="courseStates" listKey="courseId" listValue="courseName"/>
        <s:property value="courseId"/>
    <s:submit/>
</s:form>
</body>
</html>
