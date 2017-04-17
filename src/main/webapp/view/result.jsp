<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Success</title>
    </head>
    <body>
        <div style="width:600px; margin:0 auto; text-align: center;">
            <jsp:include page="include/form.jsp" />

            <div style="color:#00AA00">
                Page <b>${url}</b> successfully parsed.<br><br>
            </div>

            Total words on page: ${wordsTotal}<br><br>
            Unique words on page: ${wordOccurrence.size()}<br><br>

            <table border="1" align="center">
                <tr>
                    <th>Word</th>
                    <th>Occurrence</th>
                </tr>
                <c:forEach var="entry" items="${wordOccurrence}">
                    <tr>
                        <td>${entry.key}</td>
                        <td>${entry.value}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
