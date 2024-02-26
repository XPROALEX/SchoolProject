<%@ include file="/init.jsp" %>

<portlet:defineObjects/>

<!DOCTYPE html>
<html lang="it">


<head>


    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>

        h1 {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            font-family: Arial, sans-serif;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }


        /* style for odd rows */
        tr:nth-child(odd) {
            background-color: #f9f9f9;
        }

        /* style for even rows */
        tr:nth-child(even) {
            background-color: #ffffff;
        }

        /*  hover effect for rows */
        tr:hover {
            background-color: cornflowerblue ;
        }
    </style>

</head>


<body>


<h1>Tabella degli Esami</h1>

<table>

    <tr>
        <th>Exam</th>
        <th>Student</th>
        <th>Teacher</th>
        <th>Subject of Exam</th>
        <th>Exam Date</th>
        <th>Grade</th>
    </tr>

    <c:forEach var="exam" items="${exams}">
        <tr>
            <td>${exam.examId}</td>
            <td>${exam.studentId}</td>
            <td>${exam.teacherId}</td>
            <td>${exam.courseId}</td>
            <td>${exam.examDate}</td>
            <td>${exam.grade}</td>
        </tr>

    </c:forEach>

</table>


</body>


</html>