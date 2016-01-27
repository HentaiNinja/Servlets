<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rejestracja</title>
</head>
<body>
<form name="rejestracja" action= "Register" method="POST">
    <ul>
        <li>Nazwa użytkownika:  <input type=text id ="username" name="username" required> </li>
        <li>Hasło: <input type="password" id="password" name="password" required></li>
        <li>Potwierdź hasło: <input type="password" id="password2" name="password2" required></li>
        <li>Adres e-mail: <input type="email"  id ="email" name="email" required></li>
        <input type="submit" name="wyslij" value="wyslij formularz">
    </ul>
</form>
</body>
</html>