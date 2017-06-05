<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wellcome</title>
</head>
<body>
<center>
    <h1>Добро пожаловать</h1>
</center>
<center><table >
    <tr>
        <td class="login">Вход</td>
        <td class="register">Регистрация</td>
    </tr>
    <tr>
        <td class="login">
            <form action="/loginUser" method="post">
                <input type="text" name="login">
                <br>
                <input type="password" name="password">
                <br>
                <input type="submit" value="Войти"></form>
        </td>
        <td class="register">
            <form action="/newUser" method="post">
                <input type="text" name="new_login">
                <br>
                <input type="password" name="new_password">
                <br>
                <input type="submit" value="Зарегистрироваться"></form>
        </td>

    </tr>

</table>
    </center>
<div><center>${name}</center></div>

</body>
</html>
