<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Error</title>
    </head>
    <body>
        <div style="width:600px; margin:0 auto;">
            <div style="text-align: center;">
                <jsp:include page="include/form.jsp" />

                <div style="color:#FF0000;">
                    ${errorMessage}
                </div>
            </div>
        </div>
    </body>
</html>
