<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>EditAddress</title>
</head>
<body>
<%
    request.getSession().setAttribute("addressid", request.getParameter("addressid"));
%>
<h1>Edytuj adres</h1>
<form name="editAdress" action= "EditAddress" method="POST">
    <ul>
        <li>Typ adresu: <select name="type">
            <option value="Zameldowania">Zameldowania</option>
            <option value="Korespondencyjny">Korespondencyjny</option>
            <option value="Pracy">Pracy</option>
        </select> </li>
        <li>Województwo: <select name="region">
            <option value="dolnośląskie">dolnośląskie</option>
            <option value="kujawskopomorskie">kujawsko-pomorskie</option>
            <option value="lubelskie">lubelskie</option>
            <option value="lubuskie">lubuskie</option>
            <option value="łódzkie">łódzkie</option>
            <option value="małopolskie">małopolskie</option>
            <option value="mazowieckie">mazowieckie</option>
            <option value="opolskie">opolskie</option>
            <option value="podkarpackie">podkarpackie</option>
            <option value="podlaskie">podlaskie</option>
            <option value="pomorskie">pomorskie</option>
            <option value="śląskie">śląskie</option>
            <option value="świętokrzyskie">świętokrzyskie</option>
            <option value="warmińskomazurskie">warmińsko-mazurskie</option>
            <option value="wielkopolskie">wielkopolskie</option>
            <option value="zachodniopomorskie">zachodniopomorskie</option>
        </select></li>
        <li>Miasto: <input type="text" id="city" name="city" required></li>
        <li>Kod pocztowy: <input type="text"  id ="zipcode" name="zipcode" required></li>
        <li>Ulica: <input type="text"  id ="street" name="street" required></li>
        <li>Numer mieszkania: <input type="text"  id ="number" name="number" required></li>
        <input type="submit" name="wyslij" value="Wyslij">
    </ul>
</form>
</body>
</html>