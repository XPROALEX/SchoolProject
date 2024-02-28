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

    <style>

        #myForm {
            text-align: center;
            margin-top: 20px;
        }

        #subjectOfStudyForm {
            text-align: center;
            margin-top: 20px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"],
        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>

</head>


<body>

<form id="myForm" action="<%= myActionURL %>" method="post">
    <input type="submit" value="Esegui Sorteggio">
</form>

<p>The person who will present the project today is: ${selectedValue}</p>

<div id="subjectOfStudy">

    <h2>Text here to add Subject</h2>

    <form id="subjectOfStudyForm" action="<%= addSubjectOfStudyURL %>" method="post">
        <input type="text" name="<portlet:namespace></portlet:namespace>subjectOfStudy" required>
        <button type="submit">Text here to add Subject</button>
    </form>

</div>


</body>

</html>
