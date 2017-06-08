<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01.06.2017
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Чат</title>
</head>
<body>
<div>
    <center>Добро пожаловать в чат ${chat}</center>

</div>
<div>
    <br>
    <table>
        <tr>
            <c:forEach var="listMes" items="${message}">
        <tr>
            <td>${listMes.time}</td>
            <td>${listMes.nick} : </td>
            <td>${listMes.message}</td>
        </tr>

        </c:forEach>
        </tr>
        <tr>
            <td>
                <form action="/in/forum" method="post">
                    <input type="text" name="message">
                    <input type="submit" value="отправить сообщение">
                </form>

            </td>
        </tr>
    </table>
</div>


</body>
