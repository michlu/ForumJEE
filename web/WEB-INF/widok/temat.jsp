<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
    <h1>Temat: ${temat.tytul}</h1>
    <table border="1">
        <tr>
            <th>Login</th>
            <th width="500">Tresc</th>
            <th>Data</th>
        </tr>
        <tr>
            <td>${temat.uzytkownik.login}</td>
            <td>${temat.tresc}</td>
            <td>${temat.data}</td>
        </tr>
        <c:forEach var="wpis" items="${temat.wpis}">
            <tr>
                <td>${wpis.uzytkownik.login}</td>
                <td>${wpis.tresc}</td>
                <td>${wpis.data}</td>
            </tr>
        </c:forEach>
    </table>
    <form method="post">
        <input type="hidden" name="id" value="${temat.id}">
        <p>Wprowadz tresc odpowiedzi:</p>
        <textarea name="tresc" cols="40" rows="8"></textarea><br/>
        <input type="submit" value="OK">
    </form>

</body>
</html>
