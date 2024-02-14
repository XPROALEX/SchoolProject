<%@ include file="/init.jsp" %>
<%@ page import="javax.portlet.PortletRequest" %>

<portlet:defineObjects />

<%
String redirectUrl = (String) request.getAttribute("redirectUrl");

if(redirectUrl == null){
redirectUrl="https://www.advancia.it/lavora-con-noi/";
}

%>
<h1>Benvenuto</h1>

<c:redirect url="${redirectURL}" />