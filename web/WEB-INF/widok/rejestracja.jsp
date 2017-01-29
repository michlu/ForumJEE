<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Forum - rejestracja</title>
</head>
<body>
    <h1>Rejestracja</h1>
    ${error}
    <form method="post">
        <p>Login:</p>
        <input type="text" name="login" maxlength="30">
        <p>Wprowadz haslo:</p>
        <input type="password" name="haslo" maxlength="20">
        <p>Potwierdz haslo:</p>
        <input type="password" name="haslo2" maxlength="20"><br />
        <input type="submit" value="Rejestruj">
    </form>

</body>
</html>
