<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doações Feitas</title>
<link rel="stylesheet" type="text/css" href="index.css" media="screen" />
</head>

<body background="img/kids.jpg" bgproperties = "fixed">

<br>
<p/><a href = "perfilDoador.jsp"><img src = "img/goBack.png" align = "left" height = "50" width = "50"></a>
<br><br>

<p align = "center"><font face = "verdana" size = "5"><b>Doações Feitas</b></font>	

<br><br>
<font color="#FF0000">${erro}</font>

<div>
	<table border = "1" cellspacing="0" cellpadding="0">
		<tr bgcolor = "#4d4d4d">
			<td><p align = "center"><font face = "verdana" color = "white" size = "2">Tipo da doação</font></td>
			<td><p align = "center"><font face = "verdana" color = "white" size = "2">Data</font></td>
			<td><p align = "center"><font face = "verdana" color = "white" size = "2">Instituição</font></td>
		</tr>
		<c:forEach var="doacao" items="${doacoes}">
				<tr>
					<td bgcolor = "white"><p align = "center"><font face = "verdana" size = "2">${doacao.tipoDoacao}</font></td>
					<td bgcolor = "white"><p align = "center"><font face = "verdana" size = "2"><fmt:formatDate value="${doacao.dataDoacao}" /></font></td>
					<td bgcolor = "white"><p align = "center"><font face = "verdana" size = "2">${doacao.creche.nomeCreche}</font></td>
				</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>