<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Forum - dodaj nowy temat</title>
</head>
<body>
    <form method="post">
        <p>Wprowadz tytul tematu:</p>
        <input type="text" name="tytul" maxlength="255">
        <p>Wprowadz tresc tematu:</p>
        <textarea name="tresc" cols="40" rows="9"></textarea>><br/>
        <input type="submit" value="Dodaj">
    </form>

</body>
</html>
