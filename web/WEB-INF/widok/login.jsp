<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
    <h1>Zaloguj sie</h1>
    <form method="post" action="j_security_check">
        <p>Login:</p>
        <input type="text" name="j_username">
        <p>Hasło:</p>
        <input type="password" name="j_password">
        <input type="submit" value="Zaloguj">
    </form>
    <a href="rejestruj">Rejestracja</a>

</body>
</html>
