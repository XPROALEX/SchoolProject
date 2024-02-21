<%@ include file="/init.jsp" %>

<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.*" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>

<portlet:defineObjects/>

<!DOCTYPE html>
<html>
<head>
    <title>My Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            var resourceURL = "<portlet:resourceURL/>";
            $.ajax({
                url: resourceURL,
                type: "GET",
                dataType: "text",
                success: function(response) {
                    var values = response.split(",");
                    var randomIndex = Math.floor(Math.random() * values.length);
                    var selectedValue = values[randomIndex].trim();
                    $("#test").text(response);
                },
                error: function(xhr, status, error) {
                    console.error("Error fetching test data:", error);
                }
            });
        });
    </script>
</head>
<body>
    <h1>Test Resource</h1>
    <p>La persona che presenta il progetto oggi:</p>
    <div id="test">Loading...</div>
</body>
</html>