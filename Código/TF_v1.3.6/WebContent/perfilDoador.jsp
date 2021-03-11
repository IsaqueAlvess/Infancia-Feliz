<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil do doador</title>
</head>
<body>

<p align = "center"><font face = "verdana" size = "5">Meu Perfil</font>	
<br><br>
<p/><font size = "4">Olá, ${doador.nome}!</font><br>
	
<p align = "center"/><font size = "4">O que você quer fazer?</font>
	<br>
		<font color="#00FF00">${sucesso}</font>
		<font color="#FF0000">${erro}</font>
	<br>
<table align = "center">
	<tr>
		<td><a href = "comparaCreche.jsp"><img src = "img/doar_blocoMenu.jpg" align = "middle" height = "150" width = "150"></a></td>
		<td><a href = "doacaoCRUD?acao=listarDoacoes_Doador&id=${doador.id}"><img src = "img/doacoesAgendadas_blocoMenu.jpg" align = "middle" height = "150" width = "150"></a></td>
		<td><a href = "doacaoCRUD?acao=listarDoacoesFeitas_Doador&id=${doador.id}"><img src = "img/doacoesFeitas_blocoMenu.jpg" align = "middle" height = "150" width = "150"></a></td>
	</tr>
	<tr>				
		<td><a href = "editarDoador.jsp"><img src = "img/alterarCadastro_blocoMenu.jpg" align = "middle" height = "150" width = "150"></a></td>
		<td><a href = "doadorCRUD?acao=excluir&id=${doador.id}"><img src = "img/excluirConta_blocoMenu.jpg" align = "middle" height = "150" width = "150"></a></td>
	</tr>

</table>

<a href = "index.jsp">Sair</a>

</body>
</html>