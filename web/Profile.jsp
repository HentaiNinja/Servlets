<%@ page import="pl.javastart.domain.Address" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.javastart.sql.AddressSQL" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Twój profil</title>
</head>
<body>
<h1>Profil</h1>
<a href="addAddress.jsp">Dodaj nowy adres</a>
<form name="adresy" action= "ChangeAddress" method="POST">
    <ul>
        <%
            out.print(request.getSession().getAttribute("lista"));
        %>
    </ul>
</form>
</body>
</html>