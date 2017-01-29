<%--
  Created by IntelliJ IDEA.
  User: Michlu
  Date: 2017-01-29
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
    <h1>Forum</h1>
    <table>
        <tr>
            <th>Temat</th>
            <th>Data</th>
            <th>Autor</th>
        </tr>
        <c:forEach var="temat" items="${tematy}">
            <tr>
                <td>
                    <c:url var="url" scope="page" value="/temat">
                        <c:param name="id" value="${temat.id}"/>
                    </c:url>
                    <a href="${url}">${temat.tytul}</a>
                </td>
                <td><fmt:formatDate value="${temat.data}" dateStyle="short" timeStyle="shor" type="both"/>  </td>
                <td>${temat.uzytkownik.login}</td>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/nowyTemat" var="urlNowyTemat" scope="page" />

    <form action="${urlNowyTemat}">
        <input type="submit" value="Nowy temat">
    </form>
    <br/>
    <a href="wyloguj">Wyloguj</a>


</body>
</html>
