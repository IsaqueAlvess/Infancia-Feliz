<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="index.css" media="screen" />
</head>

<body background="img/kids.jpg" bgproperties = "fixed">
<br>
<br>
<p/><a href = "index.jsp"><img src = "img/goBack.png" align = "left" height = "50" width = "50"></a>
<br><br><br>

<font color="#FF0000">${erro}</font>

	<form method = "post" action = "crecheCRUD">
	<input type= "hidden" name = "acao" value = "loginCreche">
		<table bgcolor = "#4d4d4d" cellpadding= "1">
			<tr>
				<td><p align = "center"><font face = "verdana" size = "5" color = "white"><b>LOGIN CRECHE</b></font></td>
			</tr>
			<tr>
				<td><p align = "center"><font face = "verdana" color = "white">Usuário</font></td>
			</tr>
			<tr>
				<td><p align = "center"><input type = "text" name = "email" value = "Digite aqui seu e-mail..." style = "width:200px"></td>
			</tr>
			<tr>
				<td><p align = "center"><font face = "verdana" color = "white">Senha</font></td>
			</tr>
			<tr>
				<td><p align = "center"><input type = "password" name = "senha" style = "width:200px"><br><br></td>
			</tr>
			<tr>
				<td><p align = "center"><input type = "submit" name = "enviar" value = "Acessar" style = "width:90px;height:23px"></td>
			</tr>
		</table>
	
	</form>

</body>
</html>