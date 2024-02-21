<%@ include file="/init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL var="addExam">
	<portlet:param name="javax.portlet.action" value="myActionCommand" />
</portlet:actionURL>



<aui:form id="myForm" action="<%= addExam %>" method="post">
	<input type="submit" value="Add Exam" />
</aui:form>