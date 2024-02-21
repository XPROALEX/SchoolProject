<%@ include file="/init.jsp" %>

<portlet:defineObjects/>


<portlet:actionURL var="addExam">
    <portlet:param name="javax.portlet.action" value="addExam"/>
</portlet:actionURL>

<html>

<head>
    <title>Add Exam</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <style>
        html, body {
            min-height: 100%;
        }

        body, div, form, input, select, p {
            padding: 0;
            margin: 0;
            outline: none;
            font-family: Roboto, Arial, sans-serif;
            font-size: 14px;
            color: #666;
            line-height: 22px;
        }

        h1 {
            margin: 15px 0;
            font-weight: 400;
        }

        h2, h3 {
            margin: 15px 0;
            font-weight: 200;
        }

        .testbox {
            display: flex;
            justify-content: center;
            align-items: center;
            height: inherit;
            padding: 3px;
        }

        form {
            width: 100%;
            padding: 20px;
            background: #fff;
            box-shadow: 0 2px 5px #ccc;
        }

        input, select, textarea {
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input:hover, select:hover, textarea:hover {
            outline: none;
            border: 1px solid #095484;
        }

        input {
            width: calc(100% - 10px);
            padding: 5px;
        }

        select {
            width: 100%;
            padding: 7px 0;
            background: transparent;
        }

        textarea {
            width: calc(100% - 6px);
        }

        .item {
            position: relative;
            margin: 10px 0;
        }

        input[type="date"]::-webkit-inner-spin-button {
            display: none;
        }

        .item i, input[type="date"]::-webkit-calendar-picker-indicator {
            position: absolute;
            font-size: 20px;
            color: #a9a9a9;
        }

        .item i {
            right: 2%;
            top: 30px;
            z-index: 1;
        }

        [type="date"]::-webkit-calendar-picker-indicator {
            right: 1%;
            z-index: 2;
            opacity: 0;
            cursor: pointer;
        }

        .btn-block {
            margin-top: 20px;
            text-align: center;
        }

        button {
            width: 150px;
            padding: 10px;
            border: none;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            background-color: #095484;
            font-size: 16px;
            color: #fff;
            cursor: pointer;
        }

        button:hover {
            background-color: #0666a3;
        }
    </style>

</head>


<body>

<div class="testbox">
    <aui:form action="<%= addExam %>" method="post">
        <h1>Add Exam Form</h1>
        <div class="item">
            <h2>Tutor:</h2>
            <div>
                <h3> ${teacherName} </h3>
            </div>
        </div>

        <div class="item">
            <p>Subject of Exam</p>
            <select name="<portlet:namespace></portlet:namespace>subjectOfExam" required>
                <option value="">*Select*</option>
                <option value="1">Java</option>
                <option value="2">SQL</option>
                <option value="3">HTML</option>
                <option value="4">CSS</option>
                <option value="5">JavaScript</option>
            </select>
        </div>

        <div class="item">
            <p>Exam Date</p>
            <input type="date" name="<portlet:namespace></portlet:namespace>date" required/>
            <i class="fas fa-calendar-alt"></i>
        </div>

        <div class="item">
            <p>Student</p>
            <select name="<portlet:namespace></portlet:namespace>studentId" required>
                <option value="">*Select Student*</option>

                <c:forEach var="student" items="${students}">

                    <option value="${student.userId}">
                            ${student.fullName}
                    </option>

                </c:forEach>

            </select>
        </div>

        <div class="item">
            <p>Grade</p>
            <select name="<portlet:namespace></portlet:namespace>grade" required>
                <option value="">*Select Grade*</option>
                <option value="1.0">1</option>
                <option value="1.5">1.5</option>
                <option value="2.0">2</option>
                <option value="2.5">2.5</option>
                <option value="3.0">3</option>
                <option value="3.5">3.5</option>
                <option value="4.0">4</option>
                <option value="4.5">4.5</option>
                <option value="5.0">5</option>
                <option value="5.5">5.5</option>
                <option value="6.0">6</option>
                <option value="6.5">6.5</option>
                <option value="7.0">7</option>
                <option value="7.5">7.5</option>
                <option value="8.0">8</option>
                <option value="8.5">8.5</option>
                <option value="9.0">9</option>
                <option value="9.5">9.5</option>
                <option value="10.0">10</option>
            </select>
        </div>

        <div class="btn-block">
            <button type="submit" value="addExam">Send</button>
        </div>


    </aui:form>

</div>


</body>

</html>