<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Instituicao</title>
<link rel="stylesheet" type="text/css" href="index.css" media="screen"/>
</head>

<body background="img/kids.jpg" bgproperties = "fixed">

<p/><a href = "perfilCreche.jsp"><img src = "img/goBack.png" align = "left" height = "50" width = "50"></a>
<br><br>

<font color="#FF0000">${erro}</font>
	
	<form method = "post" action = "crecheCRUD">
		<input type = "hidden" name = "acao" value = "editar">
		
		<input type="hidden" name="id" value="${creche.id}"/>
	<div>
	<table bgcolor = "#4d4d4d" cellpadding= "10" cellspacing = "1px">
	
	
	<tr>
		<td><p align = "center"><font face = "verdana" size = "5" color = "white">Editar dados - Instituição</font></td>
	</tr>
	
	<tr>
		<td><font color = "white">CNPJ</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "cnpj" value="${creche.cnpj}" size = "50"></td>
	</tr>
	<tr>
		<td><font color = "white">Nome da Creche</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "nomeCreche" value="${creche.nomeCreche}" size = "50"></td>
	</tr>
	<tr>
		<td><font color = "white">Nome do Responsável</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "nomeResponsavel" value="${creche.nomeResponsavel}" size = "50"></td>
	</tr>
	<tr>
		<td><font color = "white">E-mail</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "email" value="${creche.email}" size = "50"></td>
	</tr>
	<tr>	
		<td><font color = "white">Telefone</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "telefone" value="${creche.telefone}" size = "50"></td>
	</tr>
	<tr>
		<td><font color = "white">Endereço</font></td>
	</tr>
	<tr>
		<td><input type = "text" name = "endereco" value="${creche.endereco}" size = "50"></td>
	</tr>
	<tr>
	<tr>
		<td><font color = "white"> Nova Necessidade Principal</font></td>
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
		<td><input type = "password" name = "senha" value="${creche.senha}" size = "50"></td>
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
