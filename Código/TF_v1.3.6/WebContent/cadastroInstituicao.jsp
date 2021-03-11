<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Instituicao</title>
<link rel="stylesheet" type="text/css" href="index.css" media="screen"/>
</head>

<body background="img/kids.jpg" bgproperties = "fixed">

<p/><a href = "index.jsp"><img src = "img/goBack.png" align = "left" height = "50" width = "50"></a>
<br><br>

<font color="#FF0000">${erro}</font>

<form method = "post" action = "crecheCRUD">
<input type = "hidden" name = "acao" value = "cadastrar">
<div>
<table bgcolor = "#4d4d4d" cellpadding= "10" cellspacing = "1px">
	
	
	
	<tr>
		<td><p align = "center"><font face = "verdana" size = "5" color = "white">Cadastro de Instituição</font></td>
	</tr>
	
	<tr>
		<td><font color = "white">CNPJ</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "cnpj"  size = "50"></td>
	</tr>
	<tr>
		<td><font color = "white">Nome da Creche</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "nomeCreche"  size = "50"></td>
	</tr>
	<tr>
		<td><font color = "white">Nome do Responsável</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "nomeResponsavel" size = "50"></td>
	</tr>
	<tr>
		<td><font color = "white">E-mail</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "email"  size = "50"></td>
	</tr>
	<tr>	
		<td><font color = "white">Telefone</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "telefone" size = "50"></td>
	</tr>
	<tr>
		<td><font color = "white">Endereço</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "endereco" size = "50"></td>
	</tr>
	
	<tr>
		<td><font color = "white">Necessidade Principal</font></td>
	</tr>
	<tr>
		<td>	<p align = "center"/><select name = "necessidadePrincipal" style = "width:255px">
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
		</td>
	
	</tr>
	
	<tr>
		<td><font color = "white">Senha</font></td>
	</tr>
		
	<tr>
		<td><input type = "password" name = "senha"  size = "50"></td>
	</tr>
	
	<tr>
		<td><p align = "center"><input type = "reset" name = "limpar" value = "Limpar">
		<input type = "submit" name = "enviar" value = "Cadastrar"></td>
	</tr>
</table>
</div>
</form>

</body>
</html>