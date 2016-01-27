<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zmiana przywilejow</title>
</head>
<body>
<form name="zmiana" action= "ChangePermission" method="POST">
    <ul>
        <b>Podaj nazwę użytkownika: </b><br>
        <li><input type=text id ="username" name="username" required> </li>
        <li>Co chcesz wykonać?</li>
        <li><input type=radio id="action"name="action" value="add">Dodaj uprawnienia</li>
        <ul>
            <li><input type=radio id="action" name="status" value="user">Standardowe uprawnienia</li>
            <li><input type=radio id="action" name="status" value="premium">Uprawnienia premium</li>
            <li><input type=radio id="action" name="status" value="admin">Uprawnienia Admina</li>
        </ul>
        <input type="submit" name="wyslij" value="Zmień     ">

    </ul>
</form>

</body>
</html>