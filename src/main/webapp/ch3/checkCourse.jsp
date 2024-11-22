<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 11. 22.
  Time: 오전 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:form action="checkCourse" method="post" theme="simple">
    <s:checkbox name="courseDto.courseStruts2" value="%{courseDto.courseStruts2}"/> Struts2
    <s:checkbox name="courseDto.courseSpringBoot" value="%{courseDto.courseSpringBoot}"/> courseSpringBoot
    <s:checkbox name="courseDto.courseNodejs" value="%{courseDto.courseNodejs}"/> courseNodejs
    <s:submit/>

    <p>
        <s:property value="courseDto.courseStateStruts.courseName"/>
        <s:property value="courseDto.courseStruts2"/>
        <s:property value="courseDto.courseStateStruts.courseDesc"/>
    </p>
    <p>
        <s:property value="courseDto.courseStateSpringBoot.courseName"/>
        <s:property value="courseDto.courseSpringBoot"/>
        <s:property value="courseDto.courseStateSpringBoot.courseDesc"/>
    </p>
    <p>
        <s:property value="courseDto.courseStateNodejs.courseName"/>
        <s:property value="courseDto.courseNodejs"/>
        <s:property value="courseDto.courseStateNodejs.courseDesc"/>
    </p>
</s:form>


</body>
<head>
    <title>CheckCourse</title>
</head>
</html>
