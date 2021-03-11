<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditarEditar Doador</title>
<link rel="stylesheet" type="text/css" href="index.css" media="screen" />
</head>

<body background="img/kids.jpg" bgproperties = "fixed">
<br>
<p/><a href = "perfilDoador.jsp"><img src = "img/goBack.png" align = "left" height = "50" width = "50"></a>
<br><br><br>

<font color="#FF0000">${erro}</font>

	<form method = "post" action = "doadorCRUD">
		<input type="hidden" name="acao" value="editar" />
	
		<input type="hidden" name="id" value="${doador.id}" />
		<div>
			<table  bgcolor = "#4d4d4d" cellpadding= "10">			
				<tr>
					<td align = "center"><font face = "verdana" size = "5" color = "white">Editar dados - Doador</font></td>
				</tr>
						
				<tr>
					<td><font color = "white">Nome</font></td>
				</tr>
				<tr>	
					<td><input type="text" name="nomeDoador" value="${doador.nome}" size = "50"></td>
					
				</tr>
				<tr>
					<td><font color = "white">Telefone</font></td>
				</tr>
				<tr>
					<td><input type="text" name="telefoneDoador" value="${doador.telefone}"  size = "50"></td>
				</tr>
				<tr>
					<td><font color = "white">E-mail</font></td>
				</tr>
				<tr>
					<td><input type="text" name="email" value="${doador.email}"  size = "50"></td>
				</tr>
				<tr>
					<td><font color = "white">Senha</font></td>
				</tr>
				<tr>
					<td><input type="password" name="senha" value="${doador.senha}"  size = "50"></td>
				</tr>
				<tr>
					<td><p align = "center"><input type = "reset" name = "limpar" value = "Limpar"> 
					<input type = "submit" name = "enviar" value = "Salvar"></td>
				</tr>
			
			</table>
		</div>
	</form>

</body>
</html>