<%--
  Created by IntelliJ IDEA.
  User: kiric
  Date: 19.06.2025
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <title>Результаты</title>
</head>
<body>
  <p><b>Результаты голосования:</b></p>
  <p>Исполнители</p>
  <table border=1>
    <tr>
      <th>Исполнитель</th>
      <th>Число голосов</th>
    </tr>
    <c:forEach items="${artistsList}" var="item">
      <tr>
        <td>${item.getName()}</td>
        <td>${item.getCountOfVotes()}</td>
      </tr>
    </c:forEach>
  </table>
  <p>Жанры</p>
  <table border=1>
    <tr>
      <th>Жанр</th>
      <th>Число голосов</th>
    </tr>
    <c:forEach items="${genresList}" var="item">
      <tr>
        <td>${item.getGenre()}</td>
        <td>${item.getCountOfVotes()}</td>
      </tr>
    </c:forEach>
  </table>
  <p>О голосовавших</p>
  <table border=1>
    <c:forEach items="${aboutsList}" var="item">
      <tr>
        <td>${item.getText()}</td>
        <td>${item.getDate()}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
