<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form method="post" action="${pageContext.request.contextPath}/">
    <input type="text" name="url" size="33" placeholder="http://" value="${url}"/>
    <input type="submit" value="Parse"/>
</form>
