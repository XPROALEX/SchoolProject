<%@ include file="/init.jsp" %>

<portlet:defineObjects/>

<portlet:actionURL var="addSubjectOfStudyURL">
    <portlet:param name="javax.portlet.action" value="addSubjectOfStudy"/>
</portlet:actionURL>

<style>

    #subjectOfStudyAdd h2 {
        text-align: center
    }

    /* Stile per il form */
    #subjectOfStudyAdd form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    /* Stile per le etichette (label) */
    #subjectOfStudyAdd label {
        margin: 5px 10px 5px 0;
    }

    /* Stile per l'input di testo */
    #subjectOfStudyAdd input[type="text"] {
        width: 50%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
        border: 2px solid #ddd;
        border-radius: 4px;
        text-align: center;
    }

    /* Stile per il pulsante */
    #subjectOfStudyAdd button {
        background-color: #0b8cb4;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 1em;
    }

    /* Stile per il pulsante al passaggio del mouse */
    #subjectOfStudyAdd button:hover {
        background-color: #087697;
    }

    #subjectOfStudyView {
        padding-top: 30px;
    }

    #subjectOfStudyView h2 {
        text-align: center
    }

    /* Stile per la tabella */
    #subjectOfStudyView table {
        border-collapse: collapse;
        width: 100%;
        margin: 25px 0;
        font-size: 0.9em;
        font-family: sans-serif;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
    }

    /* Stile per le celle dell'intestazione (th) */
    #subjectOfStudyView th {
        background-color: #f2f2f2;
        text-align: left;
        padding: 8px;
    }

    /* Stile per le celle dei dati (td) */
    #subjectOfStudyView td {
        border-bottom: 1px solid #ddd;
        padding: 8px;
    }

    /* Stile per l'ultima riga (tfoot) */
    #subjectOfStudyView tfoot td {
        font-weight: bold;
        background-color: #f2f2f2;
    }

</style>


<div id="subjectOfStudyAdd">
    <h2>text here to add Subject</h2>
    <aui:form id="subjectOfStudyForm" action="<%= addSubjectOfStudyURL %>" method="post">
        <input type="text" name="<portlet:namespace></portlet:namespace>subjectOfStudy" required>
        <button type="submit" value="addSubjectOfStudy">Add Subject of Study</button>
    </aui:form>
</div>

<div id="subjectOfStudyView">
    <h2>
        List of Subjects
    </h2>

    <table>

        <thead>
        <tr>
            <th>ID</th>
            <th>Subject</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="subject" items="${coursesList}">
            <tr>
                <td>${subject.courseId}</td>
                <td>${subject.courseName}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td>total Subjects</td>
            <td>${courseCount}</td>
        </tr>
        </tfoot>
    </table>
</div>