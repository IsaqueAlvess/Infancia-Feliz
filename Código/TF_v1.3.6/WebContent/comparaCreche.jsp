<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrando Doação</title>
<link rel="stylesheet" type="text/css" href="index.css" media="screen" />
</head>

<body>
<br>
<p/><a href = "perfilDoador.jsp"><img src = "img/goBack.png" align = "left" height = "50" width = "50"></a>
<br><br>

<p align = "center"/><img src = "img/donationBox.png" height = "150" width = "150">
<font color="#FF0000">${erro}</font>
<p align = "center"><font face = "verdana" size = "5">O que você vai doar?</font>	
<br><br>
	<form method = "post" action = "doacaoCRUD">
		<input type="hidden" name="acao" value="comparacao" />
			<p align = "center"/><select name = "tipoDoacao" style = "width:255px">
				<option>
				<option value="Alimentos">Alimentos</option>
				<option value="Roupas/cama/mesa/banho">Roupas/cama/mesa/banho</option>
				<option value="Material de limpeza em geral">Material de limpeza em geral</option>
				<option value="Material de higiene">Material de higiene</option>
				<option value="Material de expediente">Material de expediente</option>
				<option value="Material de manutenção">Material de manutenção</option>
				<option value="Utensílios para cozinha">Utensílios para cozinha</option>
				<option value="Material didático pedagógico">Material didático pedagógico</option>
				<option value="Brinquedos pedagógicos">Brinquedos pedagógicos</option>
				</select> <br><br>
			<p align = "center"/><input type = "submit" name = "enviar" value = "Buscar">
	</form>
	
		<br><br><br>
		
			<p align = "center"/><font face = "verdana" size = "4">Creches que querem sua doação...</font>
		
<div>
<table>
	<c:forEach var="creche" items="${creches}" >
	<tr>
		<p align = "center"/><td>${creche.nomeCreche}</td> <td><a href="crecheCRUD?acao=consultar&id=${creche.id}&acao2=consultar2">Consultar</a></td>
	</tr>	
	</c:forEach>
</table>
</div>
	
</body>
</html>