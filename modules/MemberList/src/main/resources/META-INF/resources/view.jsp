<%@ include file="/init.jsp" %>


<%@ page import="javax.portlet.PortletRequest" %>


<portlet:defineObjects />

<%
String userName = (String) request.getAttribute ("userName");
String userRoles = (String) request.getAttribute("userRoles");

%>

<h1>Hi ${userName} here you can see your details  </h1>
<h2> Sei un ${userRoles}</h2>


<h3>
    I tuoi gruppi sono:
    <c:forEach var="group" items="${groups}">
        ${group.name}
    </c:forEach>
</h3>

 <h1>Elenco Utenti</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Nome Utente</th>
                <th>Email</th>
                <th>Role</th>
                <th>Group</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.screenName}</td>
                    <td>${user.emailAddress}</td>
                    <td>
                    <c:forEach var="role" items="${user.roles}">
                    ${role.name} <br>
                    </c:forEach>
                    </td>
                    <td>
                    <c:forEach var="group" items="${user.userGroups}">
                            ${group.name}
                        </c:forEach>
                        </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>