<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil da creche escolhida</title>
<link rel="stylesheet" type="text/css" href="index.css" media="screen" />
</head>

<body background="img/kids.jpg" bgproperties = "fixed">
<p/><a href = "comparaCreche.jsp"><img src = "img/goBack.png" align = "left" height = "50" width = "50"></a>
<br><br><br><br><br><br>
	<form method="post" action="doacaoCRUD?acao=cadastrar"> 
		<div>
			<table  bgcolor = "#4d4d4d" cellpadding= "10">			
				
				<tr>
					<td colspan = "2" align = "center"><font face = "verdana" size = "5" color = "white">Instituição</font></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center"><font face = "verdana" size = "4" color = "white">${creche.nomeCreche}</font></td>
				</tr>
				<tr>
					<td colspan = "2"><font color = "white">Telefone: ${creche.telefone}</font></td>
				</tr>
				<tr>
					<td colspan = "2"><font color = "white">Nome do responsável: ${creche.nomeResponsavel}</font></td>
				</tr>
				<tr>
					<td colspan = "2"><font color = "white">E-mail: ${creche.email}</font></td>
				</tr>
				<tr>
					<td colspan = "2"><font color = "white">CNPJ: ${creche.cnpj}</font></td>
				</tr>
				
				<input type="hidden" name="id_Creche" value="${creche.id}" />
				<input type="hidden" name="id_Doador" value="${doador.id}" />
				<input type="hidden" name="tipoDoacao" value="${creche.necessidadePrincipal}"/>
				
				
				<tr>
					<td colspan = "2" bgcolor = "white"><font face = "verdana" size = "3"><b>Gostou da instituição? Agende já sua doação!</b></font></td>
				</tr>
				<tr>
					<td colspan = "2" bgcolor = "white"><font face = "verdana" size = "3"><b>Escolha uma data para sua doação:</b></font></td>
				</tr>
				<tr>
					<td bgcolor = "white"><font face = "verdana" size = "2"><b>Data (Seg - Sex):</b></font></td>
					<td bgcolor = "white"><input type= "date" id = "data_agendamento" name = "data_agendamento" style = "width:125px;height:23px"></td>
				</tr>
	
				<tr>
					<td colspan="2" ><p align = "center"><input type = "submit" value = "Agendar" style = "width:100px;height:23px"></td>
				</tr>
								
			</table>
		</div>
	</form>
</body>
</html>