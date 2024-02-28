<%@ include file="/init.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<portlet:actionURL var="queryResourceURL">
    <portlet:param name="javax.portlet.action" value="getByGrade"/>
</portlet:actionURL>

<html>
<head>
    <title>DynamicTest Portlet</title>
</head>
<body>
<h1>DynamicTest Portlet</h1>


<aui:form action="<%=queryResourceURL%>" method="post">
    <aui:button type="submit" value="Grades"/>
</aui:form>


<table>

    <tr>
        <th>Exam</th>
        <th>Student</th>
        <th>Teacher</th>
        <th>Subject of Exam</th>
        <th>Exam Date</th>
        <th>Grade</th>
    </tr>

    <c:forEach var="exam" items="${findByGrade}">
        <tr>
            <td>${exam[0]}</td>
            <td>${exam[1]}</td>
            <td>${exam[2]}</td>
            <td>${exam[3]}</td>
            <td>${exam[4]}</td>
            <td>${exam[5]}</td>
        </tr>

    </c:forEach>

</table>


<table>

    <tr>
        <th>Exam</th>
        <th>Student</th>
        <th>Teacher</th>
        <th>Subject of Exam</th>
        <th>Exam Date</th>
        <th>Grade</th>
    </tr>

    <c:forEach var="exam2" items="${getByGradeWithTeacherStudentCourseName}">
        <tr>
            <td>${exam2[0]}</td>
            <td>${exam2[1]}</td>
            <td>${exam2[2]}</td>
            <td>${exam2[3]}</td>
            <td>${exam2[4]}</td>
            <td>${exam2[5]}</td>
        </tr>

    </c:forEach>

</table>

</body>

</html>