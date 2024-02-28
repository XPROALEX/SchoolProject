<%@ include file="/init.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:actionURL var="myActionURL">
    <portlet:param name="javax.portlet.action" value="myActionCommand"/>
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

</body>
</html>