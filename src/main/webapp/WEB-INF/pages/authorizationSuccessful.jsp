<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 26.05.2017
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Успех</title>
</head>
<body>
<div>Поздравляю вас ${name} вы успешно зашли в чат.
    <br>
    <table>
        <td>
            <form action="/in/forum" method="post">
            <select name="chat">
                <option disabled>Выберите чат:</option>
                <option value="defaultChat"> Дефолтный чат</option>
                <option value="firstChat">чат 1</option>
                <option value="nextChat">чат 2</option>
            </select>
                <input type="submit" value="войти">
            </form>


        </td>
    </table>
</div>


</body>
</html>