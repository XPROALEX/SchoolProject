<%@ include file="/init.jsp" %>

<%@ page import="javax.portlet.PortletRequest" %>

<portlet:defineObjects />

<%
String redirectUrl = (String) request.getAttribute("redirectUrl");

if(redirectUrl == null){
redirectUrl="https://www.advancia.it/lavora-con-noi/";
}

%>

<portlet:actionURL var="getUserDetailsURL">
    <portlet:param name="javax.portlet.action" value="getUserDetails" />
</portlet:actionURL>


<aui:form action="<%= getUserDetailsURL %>" method="post">
    <aui:button type="submit" value="getUserDetails" />
</aui:form>

<h1> Welcome </h1>

<c:redirect url="${redirectUrl}" />

