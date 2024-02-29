<%@ include file="/init.jsp" %>

<portlet:defineObjects/>
<portlet:actionURL var="getExam">
    <portlet:param name="javax.portlet.action" value="getExam"/>
</portlet:actionURL>

<style>
    #aui-form {
        display: flex;
        flex-direction: column;
        gap: 1rem;
        max-width: 400px;
        margin: 0 auto;
    }

    .item {
        display: flex;
        flex-direction: column;
    }

    .item p {
        font-weight: bold;
        margin-bottom: 0.5rem;
    }

    select {
        width: 100%;
        padding: 0.5rem;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    /* Stile per la tabella */
    #getExamV2-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 2rem;
    }

    th, td {
        padding: 0.5rem;
        border: 1px solid #ddd;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
        font-weight: bold;
    }
</style>


<aui:form action="<%= getExam %>" method="post" id="getExamV2">

    <div class="item">
        <p>Teacher</p>
        <select name="<portlet:namespace></portlet:namespace>teacherId" >
            <option value="">*Select Teacher*</option>

            <c:forEach var="teacher" items="${teachers}">

                <option value="${teacher.userId}">
                        ${teacher.fullName}
                </option>

            </c:forEach>

        </select>
    </div>

    <div class="item">
        <p>Student</p>
        <select name="<portlet:namespace></portlet:namespace>studentId" >
            <option value="">*Select Student*</option>

            <c:forEach var="student" items="${students}">

                <option value="${student.userId}">
                        ${student.fullName}
                </option>

            </c:forEach>

        </select>
    </div>
    <div class="btn-block">
        <button type="submit" value="getExam">Send</button>
    </div>
</aui:form>

<table id="getExamV2-table">

    <tr>
        <th>Exam</th>
        <th>Student</th>
        <th>Teacher</th>
        <th>Subject of Exam</th>
        <th>Exam Date</th>
        <th>Grade</th>
    </tr>

    <c:forEach var="exam" items="${getExams}">
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



