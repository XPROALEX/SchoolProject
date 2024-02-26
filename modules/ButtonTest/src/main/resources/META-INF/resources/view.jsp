<%@ include file="/init.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:actionURL var="myActionURL">
    <portlet:param name="javax.portlet.action" value="myActionCommand"/>
</portlet:actionURL>

<portlet:actionURL var="addSubjectOfStudyURL">
    <portlet:param name="javax.portlet.action" value="addSubjectOfStudy"/>
</portlet:actionURL>

<html>
<head>
    <title>ButtonTest Portlet</title>
</head>
<body>
<h1>ButtonTest Portlet</h1>

<c:if test="${not empty selectedValue}">
    <p>Selected value: ${selectedValue}</p>
</c:if>

<form id="myForm" action="<%= myActionURL %>" method="post">
    <input type="submit" value="Esegui Sorteggio"/>
</form>
<p>La persona che presenta il progetto oggi: ${selectedValue}</p>

<div id="subjectOfStudy">
    <h2>text here to add Subject</h2>
    <aui:form id="subjectOfStudyForm" action="<%= addSubjectOfStudyURL %>" method="post">
        <input type="text" name="<portlet:namespace></portlet:namespace>subjectOfStudy" required>
        <button type="submit" value="addSubjectOfStudy">Add Subject of Study</button>
    </aui:form>
</div>
</body>
</html>